class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int [] num = new int [101];
        for(int i:nums){
            num[i]++;
        }
        int ans=0;
        for(int i=0;i<num.length;i++){
            if(num[i]!=0 && num[i]%k==0){
                ans+=i*num[i];
            }
        }
        return ans;
    }
}