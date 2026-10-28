class Solution {
    public long sumAndMultiply(int n) {
        long ans =0;
        StringBuilder sb = new StringBuilder();
        int sum =0;
        while(n>0){
            int b = n%10;

            n=n/10;
            if(b!=0){
                sb.append(b);
            }
            sum+=b;
        }
        String t = sb.reverse().toString();
        if(t.length()==0)
        return 0;
        ans = Integer.parseInt(t);
        return ans*sum;
    }

}