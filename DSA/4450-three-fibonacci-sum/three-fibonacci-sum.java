class Solution {
    public boolean threeFibonacciSum(int n) {
        int t = n/2;
        if(n%2==1)
        return false;

        int a=0,b=1;
        while(a+b<t){
            int j = a+b;
            b=a;
            a = j;
        }
        return a+b==t;
    }
}