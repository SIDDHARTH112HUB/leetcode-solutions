class Solution {
    public int countValidPrefixes(String s) {
        int ans =0;
        int zero =0, one =0;
        for(char c:s.toCharArray()){
            if(c=='0')
            zero++;
            else
            one++;
            ans+=Math.abs(zero-one)<2?1:0;
        }
        return ans;
    }
}