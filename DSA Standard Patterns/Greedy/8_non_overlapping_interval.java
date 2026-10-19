class Solution {
    public int eraseOverlapIntervals(int[][] in) {
         // code here
        int [][] meet = new int [in.length][2];
        for(int i=0;i<in.length;i++){
            meet[i][0] = in[i][0];
            meet[i][1] = in[i][1];
        }
        
        Arrays.sort(meet,(a,b) ->Integer.compare(a[1],b[1]));
        
        int cnt=1;
        int freeTime = meet[0][1];
        for(int i=1;i<meet.length;i++){
            if(meet[i][0]>=freeTime){
                freeTime = meet[i][1];
                cnt++;
            }
        }
        return in.length-cnt;
    }
}