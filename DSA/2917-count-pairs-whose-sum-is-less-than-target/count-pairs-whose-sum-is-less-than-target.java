// class Solution {
//     public int countPairs(List<Integer> nums, int target) {
//         int ans=0;
//         for(int i=0;i<nums.size();i++){
//             for( int j=i+1;j<nums.size();j++){
//                 if(nums.get(i)+nums.get(j)<target)
//                 ans++;
//             }
//         }
//         return ans;
//     }
// }

import java.util.*;

//m2- two pointer

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums); // O(n log n)
        int ans = 0;
        int left = 0, right = nums.size() - 1;

        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                // All pairs (left, left+1 ... right) are valid
                ans += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
