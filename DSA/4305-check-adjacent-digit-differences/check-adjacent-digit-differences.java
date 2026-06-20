class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        int a=(int)s.charAt(0);
        for(int i=1;i<s.length();i++){
            int b=(int)s.charAt(i);
            if(Math.abs(a-b)>2)
            return false;
            a=b;
        }
        return true;
    }
}