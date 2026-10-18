class Solution {
    public int minRotations(String s) {
        int curr = 0;
        int ans = 0;
        for(char c: s.toCharArray()){
            int b = c-'0';
            // System.out.print(b);
            // System.out.println(10-b+curr);
            ans+=Math.min(Math.abs(b-curr), Math.min(10-b+curr,10-curr+b));
            curr = b;
        }
        return ans;
    }
}