class Solution {
    public int dominantIndices(int[] nums) {
        int [] avg = new int[nums.length];
        int c =1;
        int n = nums.length;
        int sum = nums[n-1];
        avg[n-1] = sum;
        for(int i=n-2;i>=0;i--){
            sum+=nums[i];
            c++;
            avg[i] = sum/c;
        }
        int ans=0;
        for(int i=n-2;i>=0;i--){
            if(nums[i]>avg[i+1])
            ans++;
        }
        return ans;
    }
}