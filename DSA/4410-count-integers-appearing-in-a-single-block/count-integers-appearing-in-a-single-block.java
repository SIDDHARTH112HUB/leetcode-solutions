class Solution {
    public int countSpecialIntegers(int[] nums) {
        int [] list = new int[101];
        list[nums[0]]=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                if(list[nums[i]]==0){
                    list[nums[i]] = 1;
                }
                else{
                    list[nums[i]] = 2;
                }
            }
        }
        int ans = 0;
        for(int i:list){
            ans+= i==1?1:0;
        }
        return ans;
    }
}