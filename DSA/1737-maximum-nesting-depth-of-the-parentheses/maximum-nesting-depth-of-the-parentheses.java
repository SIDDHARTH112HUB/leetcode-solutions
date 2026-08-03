class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int a=0;
        int ans = 0;
        for(char c:s.toCharArray()){
            if(c=='('){
                st.push(c);
                ans = Math.max(st.size(),ans);
            }
            else if(c == ')'){
                st.pop();
            }
        }
        return ans;
    }
}