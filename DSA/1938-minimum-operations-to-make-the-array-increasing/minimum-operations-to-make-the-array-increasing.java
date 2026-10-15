class Solution {
    public int minOperations(int[] nums) {
        int ans =0;
        for(int i=1;i<nums.length;i++){
            ans+=Math.max(nums[i-1]+1,nums[i])-nums[i];
            nums[i]=Math.max(nums[i-1]+1,nums[i]);

        }
        return ans;
    }
}