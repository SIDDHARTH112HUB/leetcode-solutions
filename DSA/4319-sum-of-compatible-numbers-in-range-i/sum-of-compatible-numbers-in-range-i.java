class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int ans=0;
        for(int i=Math.max(1, n - k);i<=n+k;i++){
            if((i&n)==0){
                ans+=i;
            }
        }
        return ans;
    }
}