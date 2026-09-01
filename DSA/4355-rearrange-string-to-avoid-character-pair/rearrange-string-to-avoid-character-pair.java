class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbx = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c==x)
            sbx.append(c);
            else
            sb.append(c);
        }
        sb.append(sbx.toString());
        return sb.toString();
    }
}