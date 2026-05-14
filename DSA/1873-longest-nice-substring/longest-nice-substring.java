class Solution {
    public String longestNiceSubstring1(String s) {
        String ans ="";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(isNice(s.substring(i,j))){
                    if(j-i>ans.length())
                    ans=s.substring(i,j);
                }
            }
        }
        return ans;
    }
    private boolean isNice(String s){
        int []sm = new int [26];
        int []cap = new int [26];
        for(char c:s.toCharArray()){
            if(Character.isUpperCase(c)){
                cap[c-'A']=1;
            }
            else{
                sm[c-'a']=1;
            }
        }
        for(int i=0;i<26;i++){
            if((sm[i]+cap[i])%2==1)
            return false;
        }
        return true;
    }

    public String longestNiceSubstring(String s) {
        return helper(s, 0, s.length());
    }

    private String helper(String s, int start, int end) {
        if (end - start < 2) return "";
        int[] lower = new int[26], upper = new int[26];
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) lower[c - 'a'] = 1;
            else upper[c - 'A'] = 1;
        }
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c) && upper[c - 'a'] == 0 ||
                Character.isUpperCase(c) && lower[c - 'A'] == 0) {
                String left = helper(s, start, i);
                String right = helper(s, i + 1, end);
                return left.length() >= right.length() ? left : right;
            }
        }
        return s.substring(start, end);
    }
}