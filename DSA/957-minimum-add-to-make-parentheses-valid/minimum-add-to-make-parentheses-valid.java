class Solution {
    public int minAddToMakeValid(String s) {
        // Stack<Character> st = new Stack<>();
        // for(char c:s.toCharArray()){
        //     if(c=='('){
        //         st.push(c);
        //     }
        //     else {
        //         if(!st.isEmpty()&&st.peek()=='('){
        //             st.pop();
        //         }
        //         else{
        //             st.push(c);
        //         }
        //     }
        // }
        // return st.size();
        int l = 0;
        int r = 0;

        for (final char c : s.toCharArray())
        if (c == '(') {
            ++l;
        } else {
            if (l == 0)
            ++r;
            else
            --l;
        }

        return l + r;
    }
}