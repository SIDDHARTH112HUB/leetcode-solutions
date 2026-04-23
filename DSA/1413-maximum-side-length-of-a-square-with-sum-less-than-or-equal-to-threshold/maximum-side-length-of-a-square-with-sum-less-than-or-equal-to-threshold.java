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
