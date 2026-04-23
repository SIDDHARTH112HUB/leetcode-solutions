# 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold

## 📝 Problem

Given a `m x n` matrix `mat` and an integer `threshold`, return the **maximum side length of a square** such that:

```
sum of elements ≤ threshold
```

If no such square exists, return `0`.

---

## 💡 Intuition

We need to find the **largest square** whose sum is within the threshold.

### Observations:
- Larger squares → larger sums
- If a square fails → bigger ones will also fail
- This allows **optimization using prefix sum + binary search**

---

# 🚀 Approaches

---

## 🔴 Method 1 — Brute Force (TLE)

### Idea

- Try every possible top-left corner
- Expand square size
- Calculate sum manually

### ❌ Problem:
- Too slow → `O(n^4)`

---

### Code

```java
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int t = 1; i + t <= m && j + t <= n; t++) {
                    int sum = 0;

                    for (int p = i; p < i + t; p++) {
                        for (int q = j; q < j + t; q++) {
                            sum += mat[p][q];
                        }
                    }

                    if (sum <= threshold) {
                        ans = Math.max(ans, t);
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
```

---

### Complexity

- **Time Complexity:** `O(n^4)`
- **Space Complexity:** `O(1)`

---

## 🟡 Method 2 — Prefix Sum Optimization

### Idea

- Precompute prefix sum matrix
- Compute any square sum in `O(1)`
- Still try all square sizes

---

### Code

```java
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;

        int[][] preSum = new int[m][n];
        preSum[0][0] = mat[0][0];

        for (int i = 1; i < m; i++) 
            preSum[i][0] = preSum[i-1][0] + mat[i][0];

        for (int j = 1; j < n; j++) 
            preSum[0][j] = preSum[0][j-1] + mat[0][j];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                preSum[i][j] = mat[i][j] 
                             + preSum[i-1][j] 
                             + preSum[i][j-1] 
                             - preSum[i-1][j-1];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int t = 1; i + t <= m && j + t <= n; t++) {
                    int r1 = i, c1 = j;
                    int r2 = i + t - 1, c2 = j + t - 1;

                    int sum = preSum[r2][c2];
                    if (r1 > 0) sum -= preSum[r1-1][c2];
                    if (c1 > 0) sum -= preSum[r2][c1-1];
                    if (r1 > 0 && c1 > 0) sum += preSum[r1-1][c1-1];

                    if (sum <= threshold) {
                        ans = Math.max(ans, t);
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
```

---

### Complexity

- **Time Complexity:** `O(n^3)`
- **Space Complexity:** `O(n^2)`

---

## 🟢 Method 3 — Prefix Sum + Binary Search (Optimal)

### Idea

- Binary search on side length
- Check if square of size `mid` exists
- Use prefix sum to validate quickly

---

### Code

```java
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        int[][] preSum = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = mat[i-1][j-1]
                             + preSum[i-1][j]
                             + preSum[i][j-1]
                             - preSum[i-1][j-1];
            }
        }

        int ans = 0;
        int low = 1, high = Math.min(m, n);

        while (low <= high) {
            int mid = (low + high) / 2;

            if (existsSquare(preSum, mid, threshold)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean existsSquare(int[][] preSum, int len, int threshold) {
        int m = preSum.length - 1;
        int n = preSum[0].length - 1;

        for (int i = len; i <= m; i++) {
            for (int j = len; j <= n; j++) {
                int sum = preSum[i][j]
                        - preSum[i-len][j]
                        - preSum[i][j-len]
                        + preSum[i-len][j-len];

                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
```

---

### Complexity

- **Time Complexity:** `O(n^2 log n)`
- **Space Complexity:** `O(n^2)`

---

# 🔥 Key Takeaways

- Prefix sum reduces repeated calculations
- Binary search optimizes size selection
- Classic pattern:
  ```
  "maximize size under constraint"
  ```

---
