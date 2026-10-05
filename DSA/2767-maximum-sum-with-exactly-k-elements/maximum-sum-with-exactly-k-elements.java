class Solution {
    public int maximizeSum(int[] nums, int k) {
        int m = Integer.MIN_VALUE;
        for(int i:nums){
            m = Math.max(i,m);
        }
        return m*k + (k*(k-1))/2;
    }
}