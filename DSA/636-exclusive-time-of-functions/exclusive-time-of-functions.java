class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int []ans = new int[n];
        Stack<Integer> st = new Stack<>();
        int ct = 0;
        for(String s:logs ){
            String []l = s.split(":");
            int t= Integer.parseInt(l[2]);
            int p= Integer.parseInt(l[0]);
            String state = l[1];
            System.out.println(state);
            if(state.equals("start")){
                if(!st.empty()){
                    ans[st.peek()] +=t-ct;
                }
                st.push(p);
                ct =t;
            }
            else{
                ans[p] +=t-ct+1;
                st.pop();
                ct =t+1;
            }
        }
        return ans;
    }
}