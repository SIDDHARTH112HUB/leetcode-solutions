class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(c==')'){
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty()&&st.peek()!='(')
                {
                    sb.append(st.pop());
                }
                if(!st.isEmpty()&&st.peek()=='(')
                {
                    st.pop();
                }
                String str = sb.toString();
                for (char c1 : str.toCharArray()) {
                    st.push(c1); 
                }
            }
            else{
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}