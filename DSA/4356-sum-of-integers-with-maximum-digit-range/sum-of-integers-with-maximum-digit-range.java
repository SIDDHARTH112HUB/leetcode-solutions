class Solution {
    public int maxDigitRange(int[] nums) {
        int n = nums.length;
        int maxRange = 0;
        int range = 0;
        int[] individualRanges = new int[n];
        
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            if (num == 0) {
                max = 0;
                min = 0;
            } 
            while (num > 0) {
                max = Math.max(max, num % 10);
                min = Math.min(min, num % 10);
                num /= 10;
            }
            range = max - min;
            individualRanges[i] = range;
            maxRange = Math.max(maxRange, range);
        }
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            if (individualRanges[i] == maxRange) {
                totalSum += nums[i];
            }
        }
        return totalSum;
    }
}