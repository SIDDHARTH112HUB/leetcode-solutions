class Solution {
    public String maximumOddBinaryNumber(String s) {
        int t =0;
        for(char c : s.toCharArray()){
            if(c=='1')
            t++;
        }
        int n = s.length()-t;
        StringBuilder sb = new StringBuilder();
        sb.repeat('1', t-1);
        sb.repeat('0', n);
        sb.append('1');
        return sb.toString();

    }
}