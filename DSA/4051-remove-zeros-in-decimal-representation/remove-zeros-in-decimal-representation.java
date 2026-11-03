class Solution {
    public long removeZeros(long n) {
        long ans =0;
        while(n>0){
            long d = n % 10;
            n = n/10;
            if(d!=0){
                ans=ans*10 +d;
            }
        }
        n =ans;
        ans  =0;
        while(n>0){
            long d = n % 10;
            n = n/10;
            ans=ans*10 +d;
        }
        return ans;
    }
}