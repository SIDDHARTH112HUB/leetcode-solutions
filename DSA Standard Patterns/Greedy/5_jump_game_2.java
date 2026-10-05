package DSA Standard Patterns.Greedy;


//Time Complexity: O(n^n) 
// Space Complexity: O(n) Time limit exceeded for large inputs
class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)
        return 0;
        return find(nums, 0, 0);
    }
    int find(int[] nums,int ind, int jump){
        if(ind>=nums.length-1)
        return jump;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=nums[ind];i++){
            min = Math.min(min,find(nums,ind+i,jump+1));
        }
        return min;
    }
}


// time complexity: O(n^2)
// space complexity: O(n^2) 
// This solution uses memoization to store the results of previously computed states, which helps to avoid redundant calculations and improve efficiency.
// memory limit exceeded for large inputs   
class Solution {
    int [][] dp;;
    public int jump(int[] nums) {
        dp = new int [nums.length][nums.length];
        for(int i =0; i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                dp[i][j]= -1;
            }
        }
        if(nums.length==1)
        return 0;
        return find(nums, 0, 0);
    }
    int find(int[] nums,int ind, int jump){
        if(ind>=nums.length-1)
        return jump;
        if(dp[ind][jump]!=-1)
        return dp[ind][jump];
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=nums[ind];i++){
            min = Math.min(min,find(nums,ind+i,jump+1));
        }
        dp[ind][jump] = min;
        return min;
    }
}

// time complexity: O(n^2)
// space complexity: O(n)
// This solution uses memoization to store the results of previously computed states, 
// which helps to avoid redundant calculations and improve efficiency. 
// It uses a 1D array to store the minimum jumps needed from each index, 
// which reduces the space complexity compared to the previous solution that used a 2D array   
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
// time complexity: O(n)
// space complexity: O(1)
// This solution uses a greedy approach to find the minimum number of jumps needed to reach the end of the array.
// It keeps track of the current range of indices that can be reached with the current number of jumps,
// and updates the range based on the maximum index that can be reached from the current range.
class Solution {
    public int jump(int[] nums) {
        int jump =0;
        int l=0,r=0;
        while(r<nums.length-1){
            int farthest=0;
            for(int i=l;i<=r;i++){
                farthest = Math.max(i+nums[i],farthest);
            }
            jump++;
            l=r+1;
            r = farthest;
        }
        return jump;
    }
}