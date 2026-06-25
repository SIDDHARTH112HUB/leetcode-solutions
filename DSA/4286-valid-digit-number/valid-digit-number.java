class Solution {
    public boolean validDigit(int n, int x) {
        int r=-1;
        boolean one =false;
        while(n>0){
            r=n%10;
            n=n/10;
            if(r==x)
            one = true;
        }
        return one && r!=x;
    }
}