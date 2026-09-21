class Solution {
    public int countIntersectingIntervals(int[][] in) {
        Arrays.sort(in, (a, b) -> Integer.compare(a[0], b[0]));
        int ans =0;
        for(int i=0;i<in.length;i++){
            for(int j= i+1;j<in.length;j++){
                if((in[i][1]<=in[j][1] && in[i][1]>=in[j][0]) ||
                  (in[i][1]>=in[j][1] && in[i][1]>=in[j][0]))
                  ans++;
            }
        }
        return ans;
    }

}