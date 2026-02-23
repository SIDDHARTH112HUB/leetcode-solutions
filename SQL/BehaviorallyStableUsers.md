# Behaviorally Stable Users

## Intuition

A user is considered **behaviorally stable** if:

1. They perform **exactly one action per day**.
2. The action is the **same** for at least **5 consecutive days**.
3. If multiple valid streaks exist, we return only the **longest streak per user**.

This is a classic **gaps and islands** problem using window functions.

---

## Approach

### Step 1: Filter Valid Days
Keep only `(user_id, action_date)` pairs where exactly one action was performed.

### Step 2: Detect Consecutive Sequences
For each `(user_id, action)`:
- Use `ROW_NUMBER()` ordered by `action_date`
- Subtract `DATEDIFF()` from a fixed base date  
If dates are consecutive, this difference remains constant — forming a streak group.

### Step 3: Compute Streak Lengths
Group by `(user_id, action, grp)` and calculate:
- `start_date`
- `end_date`
- `streak_length`

Keep only streaks with length ≥ 5.

### Step 4: Keep Maximum Streak Per User
Use `ROW_NUMBER()` partitioned by `user_id` ordered by `streak_length DESC`.
Keep only the top streak.

### Step 5: Sort Final Output
Order by:
- `streak_length DESC`
- `user_id ASC`

---

## Complexity

- **Time Complexity:** O(n log n)  
  (window functions + grouping)

- **Space Complexity:** O(n)

---

## Code

```mssql
WITH daily AS (
    -- Keep only days with exactly one action
    SELECT 
        user_id, 
        action_date, 
        MAX(action) AS action
    FROM activity
    GROUP BY user_id, action_date
    HAVING COUNT(*) = 1
),

seq AS (
    -- Identify consecutive sequences
    SELECT 
        user_id,
        action,
        action_date,
        ROW_NUMBER() OVER (
            PARTITION BY user_id, action 
            ORDER BY action_date
        )
        - DATEDIFF(DAY, '2000-01-01', action_date) AS grp
    FROM daily
),

streaks AS (
    -- Calculate streak lengths
    SELECT 
        user_id,
        action,
        MIN(action_date) AS start_date,
        MAX(action_date) AS end_date,
        COUNT(*) AS streak_length
    FROM seq
    GROUP BY user_id, action, grp
    HAVING COUNT(*) >= 5
),

max_streak AS (
    -- Select only the maximum streak per user
    SELECT *,
           ROW_NUMBER() OVER (
               PARTITION BY user_id
               ORDER BY streak_length DESC
           ) AS rn
    FROM streaks
)

SELECT 
    user_id,
    action,
    streak_length,
    start_date,
    end_date
FROM max_streak
WHERE rn = 1
ORDER BY streak_length DESC, user_id ASC;