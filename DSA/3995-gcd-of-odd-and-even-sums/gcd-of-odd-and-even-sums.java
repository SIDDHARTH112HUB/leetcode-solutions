class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0, sume = 0;
        int o=1,e=2;
        for(int i=0;i<n;i++){
            sumOdd+=o;
            sume+=e;
            o+=2;
            e+=2;
        }
        return findGcd(sumOdd,sume);
    }
    public static int findGcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a); // Handles negative inputs safely
        }
        return findGcd(b, a % b);
    }
}