class Solution {
    public int maximumCount(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]<0){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        int negative = high+1;
        low = 0;
        high = nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]>0){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return Math.max(negative,nums.length-low);

    }
}