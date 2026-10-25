class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int a1=-1;
        int b1 =-1;
        boolean set = false;
        for(int i=0;i<nums.length;i++){
            for(int j = 0;j<nums.length;j++){
                if(nums[i]+nums[j]==target && nums[i]>nums[j]){
                    if(set == false){
                        a1 = i;
                        b1 = j;
                        set = true;
                    }
                    else if(nums[a1]*nums[b1] < nums[i]*nums[j]){
                        a1 = i;
                        b1 = j;
                    }
                }
            }
        }
        return new int []{a1,b1};
    }
}