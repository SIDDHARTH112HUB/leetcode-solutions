<h2><a href="https://leetcode.com/problems/count-number-of-nice-subarrays">Count Number of Nice Subarrays</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>Given an array of integers <code>nums</code> and an integer <code>k</code>. A continuous subarray is called <strong>nice</strong> if there are <code>k</code> odd numbers on it.</p>

<p>Return <em>the number of <strong>nice</strong> sub-arrays</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,2,1,1], k = 3
<strong>Output:</strong> 2
<strong>Explanation:</strong> The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,4,6], k = 1
<strong>Output:</strong> 0
<strong>Explanation:</strong> There are no odd numbers in the array.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,2,2,1,2,2,1,2,2,2], k = 2
<strong>Output:</strong> 16
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 50000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10^5</code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>



# 1248. Count Number of Nice Subarrays

## 📝 Problem

A subarray is called **nice** if it contains exactly `k` odd numbers.

Given an integer array `nums` and an integer `k`, return the number of **nice subarrays**.

---

## 💡 Intuition

We need subarrays with **exactly k odd numbers**.

Instead of directly counting exact `k`, we use a trick:

```
exactly(k) = atMost(k) - atMost(k - 1)
```

---

# 🚀 Method 1 — Queue Based Sliding Window

## 🔹 Approach

- Store indices of odd numbers in queue
- Maintain window
- When size > k → shrink window
- When size == k → count valid subarrays

---

## 💻 Code

```java
public int numberOfSubarraysM1UsingQueue(int[] nums, int k) {
    Queue<Integer> q = new LinkedList<>();
    int i = 0, j = 0, ans = 0;

    while (j < nums.length) {
        if (nums[j] % 2 == 1)
            q.add(j);

        while (q.size() > k) {
            i = q.poll() + 1;
        }

        if (q.size() == k) {
            ans += q.peek() - i + 1;
        }

        j++;
    }
    return ans;
}
```

---

## ⏱ Complexity

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(k)`

---

# 🚀 Method 2 — ArrayList Based Approach

## 🔹 Approach

- Track odd indices using list
- Maintain count of odds
- Adjust window when count exceeds `k`
- Compute valid subarrays using index math

---

## 💻 Code

```java
public int numberOfSubarrays(int[] nums, int k) {
    int count = 0;
    List<Integer> q = new ArrayList<>();
    int i = 0, j = 0, ans = 0;

    while (j < nums.length) {
        if (nums[j] % 2 == 1) {
            q.add(j);
            count++;
        }

        if (count > k) {
            i = q.get(q.size() - count) + 1;
            count--;
        }

        if (count == k) {
            ans += q.get(q.size() - count) - i + 1;
        }

        j++;
    }
    return ans;
}
```

---

## ⏱ Complexity

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

---

# 🚀 Method 3 — Optimal Trick (atMost K)

## 🔥 Key Idea

```
exactly(k) = atMost(k) - atMost(k - 1)
```

Why it works:

- `atMost(k)` → subarrays with ≤ k odd numbers  
- `atMost(k-1)` → subarrays with ≤ (k-1) odd numbers  
- Subtract → gives exactly k

---

## 💻 Code

```java
public int numberOfSubarrays(int[] nums, int k) {
    return atMost(nums, k) - atMost(nums, k - 1);
}

private int atMost(int[] nums, int k) {
    int i = 0, ans = 0;

    for (int j = 0; j < nums.length; j++) {
        if (nums[j] % 2 == 1) k--;

        while (k < 0) {
            if (nums[i] % 2 == 1) k++;
            i++;
        }

        ans += j - i + 1;
    }

    return ans;
}
```

---

## ⏱ Complexity

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

# 🔥 Key Takeaways

- Best pattern:
  ```
  EXACT = atMost(k) - atMost(k-1)
  ```
- Works for:
  - exactly k odd
  - exactly k distinct
  - exactly k zeros, etc.

- Most important sliding window trick 🔥

---

✔ Ready to push to GitHub 🚀
