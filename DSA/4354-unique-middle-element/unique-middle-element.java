class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int k = nums.length/2;
        int n = nums[k];
        for(int i=0;i<nums.length;i++){
            if(i!=k && nums[i]==n)
            return false;
        }
        return true;
    }
}