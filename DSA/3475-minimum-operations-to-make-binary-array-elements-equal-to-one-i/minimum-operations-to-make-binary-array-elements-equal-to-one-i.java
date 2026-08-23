class Solution {
    public int minOperations(int[] nums) {
        int c =0;
        int ans =0;
        boolean one = true;
        int i;
        for(i=0;i<nums.length-2;){
            if(nums[i]==0){
                ans++;
                nums[i+1] = (nums[i+1]+1)%2;
                nums[i+2] = (nums[i+2]+1)%2;
                
                i++;
                if(nums[i]==1){
                    i++;
                    if(nums[i]==1){
                        i++;
                    }
                }
            }
            else{
                i++;
            }
        }
        int n = nums.length;
        if(i==nums.length || (nums[n-1]==1 && nums[n-2]==1)){
            return ans;
        }
        return -1;
    }
}