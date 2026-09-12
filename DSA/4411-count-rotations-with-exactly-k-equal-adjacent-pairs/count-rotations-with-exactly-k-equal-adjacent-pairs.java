class Solution {
    public int countRotations(String s, int k) {
        int ans =0;
        for(int i=0;i<s.length();i++){
            String s1 = s.substring(i,s.length())+s.substring(0,i);
            if(checkScore(s1)==k)
            ans++;
        }
        return ans;
    }
    int checkScore(String s){
        int c =0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1))
            c++;
        }
        return c;
    }
}