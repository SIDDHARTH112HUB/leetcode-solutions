class Solution {
    public boolean checkGoodInteger(int n) {
        int ss=0,ds=0;

        while(n>0){
            int a = n%10;
            n=n/10;
            ds+=a;
            ss+=a*a;
        }
        return ss-ds>=50;
    }
}