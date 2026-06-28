class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int ans= Integer.MAX_VALUE;
        int one=-1,two=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
            one=i;
            else if(nums[i]==2)
            two=i;

            if(one!=-1 && two != -1)
            ans= Math.min(Math.abs(one-two), ans);
        }

        return ans==Integer.MAX_VALUE?-1:ans;
    }
}