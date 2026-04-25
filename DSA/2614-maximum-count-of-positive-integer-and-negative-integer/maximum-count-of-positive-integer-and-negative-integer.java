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

// class Solution {
//     public int maximumCount(int[] nums) {
//         int n = nums.length;
        
//         // Find first non-negative (>= 0)
//         int firstNonNeg = lowerBound(nums, 0);
        
//         // Find first positive (> 0)
//         int firstPos = lowerBound(nums, 1);
        
//         int negatives = firstNonNeg;          // count of < 0
//         int positives = n - firstPos;         // count of > 0
        
//         return Math.max(negatives, positives);
//     }
    
//     // Standard lower_bound implementation
//     private int lowerBound(int[] nums, int target) {
//         int low = 0, high = nums.length;
//         while (low < high) {
//             int mid = low + (high - low) / 2;
//             if (nums[mid] < target) {
//                 low = mid + 1;
//             } else {
//                 high = mid;
//             }
//         }
//         return low;
//     }
// }
