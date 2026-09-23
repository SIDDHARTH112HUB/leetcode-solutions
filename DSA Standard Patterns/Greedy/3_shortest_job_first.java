class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int time =0;
        int sum=0;
        for(int i=1;i<bt.length;i++){
            time += bt[i-1];
            sum+=time;
        }
        return sum/bt.length;
    }
}
