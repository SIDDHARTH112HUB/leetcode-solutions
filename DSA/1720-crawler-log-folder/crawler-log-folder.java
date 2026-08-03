class Solution {
    public int minOperations(String[] logs) {
        int ans =0;
        for(String s:logs){
            if(s.charAt(0)!='.'){
                ans++;
            }
            else if(s.charAt(1)=='.'){
                ans--;
                ans = Math.max(0,ans);
            }
        }
        return ans;
    }
}