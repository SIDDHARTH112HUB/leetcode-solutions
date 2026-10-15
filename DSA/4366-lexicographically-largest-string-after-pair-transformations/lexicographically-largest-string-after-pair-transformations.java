class Solution {
    public String[] largestString(int[] nums) {
        String ans[] = new String[nums.length];
        int i=0;
        for(int k:nums){
            ans[i] = getValue(k);
            i++;
        }
        return ans;
    }
    String getValue(int n){
        StringBuilder sb = new StringBuilder();
        char c = 'a';

        while(n>0 && c!='z'){
            if(n%2==1){
                sb.append(c);
            }
            n=n/2;
            c++;
        }
        while(n>0){
            sb.append('z');
            n--;
        }
        return sb.reverse().toString();
    }
}