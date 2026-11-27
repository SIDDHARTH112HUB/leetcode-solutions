class Solution {
    public boolean checkDivisibility(int n) {
        int s=0,a=1;
        int t=n;
        while(n>0){
            int d = n%10;
            n=n/10;
            s+=d;
            a=a*d;
        }
        s+=a;
        return t%s==0;
    }
}