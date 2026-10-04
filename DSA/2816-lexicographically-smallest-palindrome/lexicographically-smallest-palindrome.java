class Solution {
    public String makeSmallestPalindrome(String s) {
        char [] st = new char[s.length()];
        int i=0,j=s.length()-1;
        while(i<j){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            char c = c1;
            if(c1!=c2){
                if(c1>c2){
                    c=c2;
                }
            }
            st[i]=c;
            st[j]=c;
            i++;
            j--;
        }
        if(i==j){
            st[i] = s.charAt(i);
        }
        String sr = new String(st);
        return sr;
    }
}