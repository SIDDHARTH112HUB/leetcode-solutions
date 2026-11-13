class Solution {
    public int earliestTime(int[][] tasks) {
        int ans = tasks[0][0] + tasks[0][1];
        for(int []a:tasks){
            ans = Math.min(ans, a[0]+a[1]);
        }
        return ans;
    }
}