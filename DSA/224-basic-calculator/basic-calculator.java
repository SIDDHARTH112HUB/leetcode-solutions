class Solution {
    public int calculate(String s) {
        int sum=0;
        int sign =1;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int value=0;
                while(i<s.length()&&Character.isDigit(s.charAt(i))){
                    value= value*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                value = value*sign;
                sum+=value;
                sign = 1;
            }
            else if(c=='('){
                st.push(sum);
                st.push(sign);
                sign=1;
                sum =0;
            }
            else if(c==')'){
                sum*=st.pop();
                sum+=st.pop();

            }else if(c=='-'){
                sign*=-1;
            }
        }
        return sum;
    }
}