class Solution {
    public boolean canJump(int[] nums) {
        int maxj =0;
        for(int i=0;i<nums.length;i++){
            if(i<=maxj){
                maxj=Math.max(maxj,nums[i]+i);
            }
            else{
                return false;
            }
        }
        return true;
    }
}