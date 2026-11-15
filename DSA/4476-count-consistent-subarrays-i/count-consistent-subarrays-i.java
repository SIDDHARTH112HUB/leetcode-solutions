class Solution {
    public int countConsistent(int[] nums) {
        int ans =0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int min = nums[i];
                int and = nums[i];

                for (int k = i; k <= j; k++)
                {
                    min = Math.min(nums[k],min);
                    and = and & nums[k];
                }
                if(min == and)
                ans++;
            }
        }
        return ans;
    }
}