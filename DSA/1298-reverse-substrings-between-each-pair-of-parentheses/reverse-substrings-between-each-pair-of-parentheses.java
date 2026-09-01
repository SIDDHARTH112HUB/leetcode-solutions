class Solution {
    public String reverseParentheses1(String s) {
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
    static int i=0;
    public String reverseParentheses(String s) {
        i=0;
        String s1=helper(s);
        return s1;
    }
    static String helper(String s){
        
        StringBuilder sb=new StringBuilder();
        while(i<s.length()){
            if(s.charAt(i)=='('){
                i++;
                sb.append(helper(s));
                
            }
            else if(s.charAt(i)==')'){
                i++;
                return sb.reverse().toString();
            }
            else{
                sb.append(s.charAt(i)+"");
                i++;
            }
        }
        return sb.toString();
    }
}