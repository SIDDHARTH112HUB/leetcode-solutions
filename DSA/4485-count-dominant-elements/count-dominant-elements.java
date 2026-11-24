class Solution {
    public int countDominantElements(int[] nums) {
        int ans =0;
        if(nums.length==1)
        return 1;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i] >= 1.0*(nums[i-1]+nums[i+1])/2)
            ans++;
        }
        if(nums.length>1){
            if(nums[0]>=nums[1])
            ans++;

            if(nums[nums.length-1]>=nums[nums.length-2])
            ans++;
        }
        return ans;
    }
}