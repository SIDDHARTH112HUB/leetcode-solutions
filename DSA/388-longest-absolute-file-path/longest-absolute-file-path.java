class Solution {
    public int lengthLongestPath(String input) {
        String[] l  = input.split("\n");
        int ans =0;
        Stack<String> st = new Stack<>();
        for(String s:l ){
            System.out.println(s);
            StringBuilder sb = new StringBuilder();
            int t=0;
            for(char c:s.toCharArray()){
                if(c=='\t'){
                    t++;
                }
                else{
                    sb.append(c);
                }
            }
            while(t<st.size()){
                st.pop();
            }
            String tt = sb.toString();
            st.push(tt);
            System.out.println(tt);
            String ts = String.join("/", st);
            System.out.println(ts);

            if(tt.contains(".")){

                ans = Math.max(ts.length(),ans);
            }
            
        }
        return ans;
    }
}