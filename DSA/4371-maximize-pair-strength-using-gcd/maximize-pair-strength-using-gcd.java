class Solution {
    public long maxPairStrength(int[] nums) {
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                long a = nums[i];
                long b = nums[j];
                long g = gcd(nums[i],nums[j]);
                //System.out.println(g);
                //System.out.println(a);
                //System.out.println(b);
                long c = a*b;
                long d= g*g;
                //System.out.println(c);
                //System.out.println(d);

                ans = Math.max(ans, c/d );
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