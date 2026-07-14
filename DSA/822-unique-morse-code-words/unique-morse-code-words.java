class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String [] l = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> st = new HashSet<>();
        for(String s:words){
            String a = "";
            for(char c: s.toCharArray()){
                a+=l[c-'a'];
            }
            st.add(a);
        }
        return st.size();
    }
}