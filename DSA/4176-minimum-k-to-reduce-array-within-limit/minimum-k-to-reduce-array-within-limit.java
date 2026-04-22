class Solution {
    public int minimumK(int[] nums) {
        int low = 1;
        int high = 100000;
        while (low<high){
            int mid = (low + high) / 2;
            if(nonPositive(nums,mid)){
                high =mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private boolean nonPositive(int []nums, long k){
        long  sq = k*k;
        long total=0;
        for (int i:nums){
            total+=(i+k-1)/k;
        }
        return total<=sq;
    }
}