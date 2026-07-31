class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<Character> sts = new Stack<>();
        char prev='+';
        int sign =1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int value = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    value = value * 10 + (s.charAt(i) - '0');
                    i++;
                }
                if(sts.size()>0&&(sts.peek()=='*' || sts.peek()=='/')){
                    int a = st.pop();
                    char ch = sts.pop();
                    if(ch=='*'){
                        st.push(value*a);
                    }
                    else{
                        st.push(a/value);
                    }
                }
                else{
                    st.push(sign * value);
                    sign =1;
                }
                i--;
            }
            else if(c=='-'){
                sign =-1;
            }
            else if(c=='*'||c=='/'){
                sts.push(c);
                sign = 1;
            }
        }
        int ans =0;
        while(st.size()>0){
            ans+=st.pop();
        }
        return ans;
    }
}