class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n=nums.length;
        int[] ans= new int [n];
        int odd=0, ev=0;

        for(int i=n-1;i>=0;i--){
            if(i!=n-1){
                ans[i]=nums[i]%2==0?odd:ev;
            }
            if(nums[i]%2==0)
            ev++;
            else
            odd++;
        }
        return ans;
    }
}