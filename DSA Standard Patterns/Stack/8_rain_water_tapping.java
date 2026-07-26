// optimized approach
// here we are calculating the max height to the left and right of each index and then calculating the water trapped at that index.
// This is an optimized approach with O(n) time complexity and O(n) space complexity.
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxl = new int[n]; // max height to the left of each index
        int[] maxr = new int[n]; // max height to the right of each index

        // Initialize boundaries
        maxl[0] = height[0];
        maxr[n - 1] = height[n - 1];

        // Fill maxl: for each i, store tallest bar to the left (including itself)
        for (int i = 1; i < n; i++) {
            maxl[i] = Math.max(height[i], maxl[i - 1]);
        }

        // Fill maxr: for each i, store tallest bar to the right (including itself)
        for (int i = n - 2; i >= 0; i--) {
            maxr[i] = Math.max(height[i], maxr[i + 1]);
        }

        int ans = 0;
        // Water trapped at index i = min(maxl[i], maxr[i]) - height[i]
        for (int i = 0; i < n; i++) {
            ans += Math.min(maxl[i], maxr[i]) - height[i];
        }
        return ans;
    }
}


//brute force
// here we are calculating the max height to the left and right of each index and then calculating the water trapped at that index. 
// This is a brute force approach with O(n^2) time complexity. 
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;

        // For each bar, compute trapped water
        for (int i = 0; i < n; i++) {
            int maxLeft = 0;
            int maxRight = 0;

            // Find tallest bar to the left
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            // Find tallest bar to the right
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            // Water trapped at i
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }
}
