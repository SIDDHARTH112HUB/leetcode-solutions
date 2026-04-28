// class Solution {
//     public int incremovableSubarrayCount(int[] nums) {
//         int n = nums.length;
//         boolean[] prefixInc = new boolean[n];
//         boolean[] suffixInc = new boolean[n];

//         // Precompute prefix increasing
//         prefixInc[0] = true;
//         for (int i = 1; i < n; i++) {
//             prefixInc[i] = prefixInc[i - 1] && nums[i - 1] < nums[i];
//         }

//         // Precompute suffix increasing
//         suffixInc[n - 1] = true;
//         for (int i = n - 2; i >= 0; i--) {
//             suffixInc[i] = suffixInc[i + 1] && nums[i] < nums[i + 1];
//         }

//         int ans = 0;
//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 boolean leftOk = (i == 0) || prefixInc[i - 1];
//                 boolean rightOk = (j == n - 1) || suffixInc[j + 1];
//                 boolean bridgeOk = (i == 0 || j == n - 1) || nums[i - 1] < nums[j + 1];

//                 if (leftOk && rightOk && bridgeOk) {
//                     ans++;
//                 }
//             }
//         }
//         return ans;
//     }
// }


// class Solution {
//     public long incremovableSubarrayCount(int[] nums) {
//         int n = nums.length;
//         if(n == 1) return 1;
//         if(n == 2) {
//             return 3;
//         }
        
//         long ans = 1; // removing all would be a solution

//         // left increasing
//         int left = 0;
//         while(left < n-1 && nums[left] < nums[left+1]) {
//             left++;
//         }
//         ans += left + 1l;
        
//         // right increasing
//         int right = n-1;
//         while(right > 0 && nums[right-1] < nums[right]) {
//             right--;
//         }
//         ans += n - right;
            
//         // if all are increasing
//         if(left >= right) {
//             return ((n)*(n+1))/2l;
//         }

//         left = 0;
//         // middle handling
//         while(left < right && right < n) {
//             if(nums[left] < nums[right]) {
//                 ans += right == n-1 ? 1l : (long)(n-right);
//                 if(left < n-1 && nums[left] < nums[left+1])
//                     left++;
//                 else 
//                     break;
//             } else {
//                 right++;
//             }
//         }
        
//         return ans;
//     }
// }
import java.util.*;

class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;

        // Step 1: build increasing suffix
        List<Integer> lastInc = new ArrayList<>();
        lastInc.add(nums[n - 1]);
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] >= nums[i + 1]) break;
            lastInc.add(nums[i]);
        }
        Collections.reverse(lastInc); // put in ascending order

        // Step 2: if whole array is increasing
        if (lastInc.size() == n) {
            return (long) n * (n + 1) / 2;
        }

        // Step 3: initial answer (remove all + suffix removals)
        long ans = 1 + lastInc.size();
        int prefixLen = n - lastInc.size();

        // Step 4: handle prefix + suffix combinations
        int last = -1;
        for (int i = 0; i < prefixLen; ++i) {
            if (nums[i] <= last) break; // prefix must remain strictly increasing
            last = nums[i];

            // binary search equivalent of upper_bound
            int idx = upperBound(lastInc, nums[i]);
            ans += (lastInc.size() - idx) + 1;
        }

        return ans;
    }

    // Java equivalent of C++ upper_bound
    private int upperBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}

// class Solution {
//     public long incremovableSubarrayCount(int[] nums) {
//         int n = nums.length;
//         int j = n - 1;

//         // find longest increasing suffix
//         while (j > 0 && nums[j - 1] < nums[j]) {
//             j--;
//         }

//         // if whole array is strictly increasing
//         if (j == 0) {
//             return (long) n * (n + 1) / 2;
//         }

//         long res = 1 + (n - j); // removing all + suffix removals

//         // two-pointer sweep
//         for (int i = 1; i < n; i++) {
//             j = Math.max(i + 1, j);
//             while (j < n && nums[i - 1] >= nums[j]) {
//                 j++;
//             }
//             res += 1 + (n - j); // count valid removals
//             if (nums[i - 1] >= nums[i]) {
//                 break; // prefix no longer strictly increasing
//             }
//         }

//         return res;
//     }
// }
