class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i < nums.length;i++){
            int a = nums[i];
            if(nums[Math.abs(a)-1]<0)
            return Math.abs(a);
            nums[Math.abs(nums[i]) - 1] *= -1;
        }
        return -1;
    }
}