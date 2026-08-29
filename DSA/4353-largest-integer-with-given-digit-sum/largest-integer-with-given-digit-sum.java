class Solution {
    public int largestInteger(int n, int s) {
        int ans = -1;
        int num = (int)Math.pow(10, n)-1;
        for(int i=0;i<=num;i++){
            int ds = digitsum(i);
            if(ds==s)
            {
                ans = i;
            }
        } 
        return ans;
    }
    public int digitsum(int num){
        int ans =0;
        while(num>0){
            ans+=num%10;
            num=num/10;
        }
        return ans;
    }
}