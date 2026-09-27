class Solution {
    int[] dp;
    
    public int jump(int[] nums) {
        dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i] = -1;
        }
        return find(nums, 0);
    }
    
    int find(int[] nums, int ind){
        // Base case: If we are at or past the last index, 0 additional jumps are needed.
        if (ind >= nums.length - 1) {
            return 0;
        }
        
        // Return the cached result if we have already computed this index
        if (dp[ind] != -1) {
            return dp[ind];
        }
        
        // Use a high arbitrary number instead of Integer.MAX_VALUE to prevent 
        // integer overflow when we add 1 to it below. (10000 is safe since N <= 10^4)
        int min = 10000; 
        
        for (int i = 1; i <= nums[ind]; i++) {
            // 1 jump from current + minimum jumps from the next index
            min = Math.min(min, 1 + find(nums, ind + i));
        }
        
        dp[ind] = min;
        return min;
    }
}