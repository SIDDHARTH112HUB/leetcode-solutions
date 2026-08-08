class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int k=0;
        for(int i=0;i<pushed.length;i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && k<popped.length && st.peek()==popped[k]){
                st.pop();
                k++;
            }
        }
        return st.isEmpty();
    }
}