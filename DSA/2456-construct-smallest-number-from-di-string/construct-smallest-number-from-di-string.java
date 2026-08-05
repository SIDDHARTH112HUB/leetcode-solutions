class Solution {
    public String smallestNumber(String p) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=p.length();i++){
            st.push(i+1);
            while(!st.isEmpty() && (i==p.length() ||p.charAt(i)=='I')){
                sb.append(st.pop().toString());
            }
        }
        return sb.toString();
    }
}