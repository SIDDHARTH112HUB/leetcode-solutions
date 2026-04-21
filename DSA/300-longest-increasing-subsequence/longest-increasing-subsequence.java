M-1 DP O(n^2) time complexity

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int a = 1; a < nums.length; a++) {
            for (int b = a-1; b >= 0; b--) {
                if (nums[b] < nums[a]) {
                    dp[a] = Math.max(dp[a], dp[b] + 1);
                    max = Math.max(max, dp[a]);
                }
                if (dp[a] > b) break;
            }
        }
        return max;
    }
}


M2- NlogN time complexity

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        List<Integer> tails = new ArrayList<>();
        
        for (int num : nums) {
            // Collections.binarySearch returns the index of num
            // or (-(insertion point) - 1) if not present
            int index = Collections.binarySearch(tails, num);
            
            // If not found, convert negative result to the actual insertion point
            if (index < 0) {
                index = -(index + 1);
            }
            
            if (index == tails.size()) {
                tails.add(num);
            } else {
                tails.set(index, num);
            }
        }
        
        return tails.size();
    }
}

