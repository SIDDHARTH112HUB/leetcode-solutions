class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int a=m;
        int b=n;
        for(int [] ar:ops){
            a= Math.min(ar[0],a);
            b= Math.min(ar[1],b);
        }
        return a*b;
    }
}