class Solution {
    public int[] diStringMatch(String s) {
        int i=0;
        int j=s.length();
        int []ans = new int[s.length()+1];
        int t=0;
        for(char k:s.toCharArray())
        {
            if(k=='D')
                ans[t++]=j--;
            else
                ans[t++]=i++;
        }
        ans[t] =j;
        return ans;
    }
}