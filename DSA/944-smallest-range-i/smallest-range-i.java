class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i:nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        int v = max-min-2*k;
        //return max;
        return v<=0?0:v;
    }
}