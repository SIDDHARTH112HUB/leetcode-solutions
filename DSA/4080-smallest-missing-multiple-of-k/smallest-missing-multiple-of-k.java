class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int t =1;
        int s=k*t;
        int i=0;
        while(i<nums.length && nums[i]<=s){
            if(nums[i]==s){
                t++;
                s= k*t;
            }
            else if(nums[i]>s){
                return s;
            }
            else{
                i++;
            }
        }
        return s;
    }
}