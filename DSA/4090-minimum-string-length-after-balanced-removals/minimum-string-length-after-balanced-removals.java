class Solution {
    public int minLengthAfterRemovals(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(st.size()==0 || st.peek()==c){
                st.push(c);
            }
            else{
                st.pop();
            }
        } 
        return st.size();
    }
}