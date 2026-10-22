class Solution {
    public String reversePrefix(String s, int k) {
        int i=0;
        StringBuilder sb = new StringBuilder();
        for(i=0;i<k;i++){
            sb.append(s.charAt(i));
        }
        sb = sb.reverse();
        for(;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}