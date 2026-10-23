class Solution {
    public int mirrorDistance(int n) {
        String str = new StringBuilder(String.valueOf(n)).reverse().toString();
        return Math.abs(n-Integer.parseInt(str));

    }
}