class Solution {
    public long maxPairStrength(int[] nums) {
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int g = gcd(nums[i],nums[j]);
                long t = 1;
                ans = Math.max(ans, (t*nums[i]*nums[j])/(t*g*g) );
            }
        }
        return ans;
    }
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}