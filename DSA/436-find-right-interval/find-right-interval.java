class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int [] ans  = new int[intervals.length];
        TreeMap<Integer,Integer> mp = new TreeMap<>();

        for(int i=0;i<intervals.length;i++){
            mp.put(intervals[i][0],i);
        }
        for(int i=0;i<intervals.length;i++){
            int k = intervals[i][1];
            Integer nextStart = mp.ceilingKey(k);
            if (nextStart != null) {
                ans[i]=mp.get(nextStart);
            }
            else{
                ans[i]=-1;
            }
        }
        return ans;

    }
}