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
