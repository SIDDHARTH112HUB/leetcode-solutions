class Solution {
    public int nearestDrone(int[][] drones, int[] tg) {
        int ans =-1;
        int mind = Integer.MAX_VALUE;
        int j=0;
        for(int t[]: drones){
            
            int d = Math.abs(t[0]-tg[0])+ Math.abs(t[1]-tg[1]);
            if(d<=t[2]){
                if(d<mind){
                    mind = d;
                    ans = j;
                }
            }
            j++;
        }
        return ans;
    }
}