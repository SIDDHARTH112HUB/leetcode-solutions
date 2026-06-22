class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(char c:s.toCharArray()){
            if( c=='(' || c=='[' || c=='{'){
                st.push(c);
            }
            else{
                if(st.size()<=0)
                return false;
                char b = st.pop();
                if((c==')'&& b!='(') || (c==']'&& b!='[') || (c=='}'&& b!='{'))
                return false;
            }
        } 
        if(st.size()>0)
        return false;
        return true;
    }
}
