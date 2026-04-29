class Solution {
    public int maxProfit(int[] p) {
        int m=p[0];
        int ans=0;
        int j=1;
        while(j<p.length){
            m = Math.min(m, p[j]);
            ans = Math.max(p[j]-m,ans);
            j++;
        }

        return ans;
    }
}
