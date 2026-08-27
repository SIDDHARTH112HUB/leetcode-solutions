class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int ans =0;
        int c = 0;
        for(int i:requests){
            ans+=Math.abs(c-i);
            c=i;
        }
        return ans;
    }
}