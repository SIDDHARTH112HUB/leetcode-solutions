class Solution {
    public int clumsy(int n) {
        char [] sign = {'*','/','+','-'};
        int i=0;
        Stack<Integer> st = new Stack<>();
        while(n>0){
            if(st.isEmpty()){
                st.push(n);
            }
            else{
                if(sign[i%4]=='*' || sign[i%4]=='/'){
                    int a = st.pop();
                    if(sign[i%4]=='*'){
                        st.push(a*n);
                    }
                    else{
                        st.push(a/n);
                    }
                }
                else if(sign[i%4]=='-'){
                    st.push(-1*n);
                }
                else{
                    st.push(n);
                }
                i++;
            }
            n--;
        }
        int ans =0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}