class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int count = 0;

        int l = 0;
        int r = n - 1;

        while (l < r) {
            if (nums[l] == 0 && nums[r] != 0) {
                swap(nums, l, r);
                count++;
                l++;
                r--;
            } 
            else if (nums[l] != 0) {
                l++;
            } 
            else if (nums[r] == 0) {
                r--;
            }
        }

        return count;
    }
}