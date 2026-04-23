M1 - Brute Force TLE

class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;

        // Try every possible top-left corner (i, j)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Expand square size t starting from 1
                for (int t = 1; i + t <= m && j + t <= n; t++) {
                    int sum = 0;

                    // Compute sum of all elements in the t x t square
                    for (int p = i; p < i + t; p++) {
                        for (int q = j; q < j + t; q++) {
                            sum += mat[p][q];
                        }
                    }

                    // Check threshold
                    if (sum <= threshold) {
                        ans = Math.max(ans, t);
                    } else {
                        // No point in expanding further, sum will only increase
                        break;
                    }
                }
            }
        }
        return ans;
    }
}

M2 - Prefix Sum 
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;

        // Build prefix sum matrix
        int[][] preSum = new int[m][n];
        preSum[0][0] = mat[0][0];
        for (int i = 1; i < m; i++) preSum[i][0] = preSum[i-1][0] + mat[i][0];
        for (int j = 1; j < n; j++) preSum[0][j] = preSum[0][j-1] + mat[0][j];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                preSum[i][j] = mat[i][j] 
                             + preSum[i-1][j] 
                             + preSum[i][j-1] 
                             - preSum[i-1][j-1];
            }
        }

        // Try every possible top-left corner (i, j)
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
                        break; // larger squares will only increase sum
                    }
                }
            }
        }
        return ans;
    }
}

M3 - Prefix Sum + Binary Search


class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        // Build prefix sum matrix
        int[][] preSum = new int[m+1][n+1]; // +1 for easier boundaries
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

        // Binary search on side length
        while (low <= high) {
            int mid = (low + high) / 2;
            if (existsSquare(preSum, mid, threshold)) {
                ans = mid;       // mid works, try bigger
                low = mid + 1;
            } else {
                high = mid - 1;  // mid too large, try smaller
            }
        }
        return ans;
    }

    // Check if any square of side 'len' has sum <= threshold
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
