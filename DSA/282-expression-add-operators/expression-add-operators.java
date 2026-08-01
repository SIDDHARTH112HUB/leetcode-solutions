class Solution {
    List<String> ans;
    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        int i=0;
        String s="";
        char c = num.charAt(i);
        if(c=='0'){
            check(num,i+1, "0",target);
        }
        else{
            
            for(;i<num.length();i++){
                s+=num.charAt(i);
                check(num,i+1,s,target);
            }
        }
        return ans;
    }
    public void check(String num, int i, String s,int t){
        if(i==num.length()){
            long a = calculate(s);
            if(a==(long)t){
                System.out.print(s+ " ");
                System.out.println(a);
                ans.add(s);
            }
            return;
        }
        char c = num.charAt(i);
        if(c=='0'){
            check(num,i+1, s+"+"+num.charAt(i),t);
            check(num,i+1, s+"-"+num.charAt(i),t);
            check(num,i+1, s+"*"+num.charAt(i),t);
        }
        else{
            String st = "";
            for(;i<num.length();i++){
                st+=num.charAt(i);
                check(num,i+1, s+"+"+st,t);
                check(num,i+1, s+"-"+st,t);
                check(num,i+1, s+"*"+st,t);
            }
        }
    }
    public long calculate(String s) {
        Stack<Long> st = new Stack<>();
        Stack<Character> sts = new Stack<>();

        long sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                long value = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    value = value * 10 + (s.charAt(i) - '0');
                    i++;
                }

                if (!sts.isEmpty() && sts.peek() == '*') {
                    long previous = st.pop();
                    sts.pop();
                    st.push(previous * value);
                } else {
                    st.push(sign * value);
                    sign = 1;
                }
                i--;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '*') {
                sts.push(c);
                sign = 1;
            }
        }

        long ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }

}