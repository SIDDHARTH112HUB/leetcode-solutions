class Solution {
    public String getSmallestString(String s) {
        char[] c = s.toCharArray();
        for(int i=0;i<c.length-1;i++){
            int a = c[i]-'0';
            int b = c[i+1]-'0';
            //System.out.println(a+" "+b);
            if(((a%2==0 && b%2==0)||(a%2==1 && b%2==1)) && a>b){
                char t = c[i];
                c[i]=c[i+1];
                c[i+1] =t;
                break;
            }
        }
        String ans = new String(c);
        return ans;
    }
}