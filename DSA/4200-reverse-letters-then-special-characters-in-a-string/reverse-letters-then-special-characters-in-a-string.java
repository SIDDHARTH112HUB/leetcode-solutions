class Solution {
    public String reverseByType(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(char c :s.toCharArray()){
            if(Character.isLetter(c))
            sb2.append(c);
            else
            sb.append(c);
        }
        String sc = sb.reverse().toString();
        String ss = sb2.reverse().toString();
        int i=0,j=0;
        for(char c :s.toCharArray()){
            if(Character.isLetter(c))
            {
                ans.append(ss.charAt(i));
                i++;
            }
            else
            {
                ans.append(sc.charAt(j));
                j++;
            }
        }
        return ans.toString();
    }
}