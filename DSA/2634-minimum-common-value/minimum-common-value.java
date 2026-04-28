// M1 - Two Pointers
// class Solution {
//     public int getCommon(int[] nums1, int[] nums2) {
//         int i=0,j=0;
//         if(nums1[nums1.length-1]<nums2[0] || nums2[nums2.length-1]<nums1[0]){
//             return -1;
//         }
//         while(i<nums1.length && j<nums2.length){
//             if(nums1[i]==nums2[j])
//             return nums1[i];
//             if(nums1[i]>nums2[j])
//             j++;
//             else
//             i++;
//         }
//         return -1;
//     }
// }


// M2 - Binary Search
public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // Binary search should be done on the larger array
        // If nums1 is longer, call getCommon with the arrays swapped
        if (nums1.length > nums2.length) {
            return getCommon(nums2, nums1);
        }
        
        // Search for each element of nums1 in nums2
        // Return the first common element found
        for (int num : nums1) {
            if (binarySearch(num, nums2)) {
                return num;
            }
        }

        // Return -1 if there are no common elements
        return -1;
    }

    private boolean binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}