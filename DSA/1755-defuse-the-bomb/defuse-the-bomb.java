class Solution {
    public int[] decrypt(int[] nums, int k) {
        int n = nums.length;
        int []ans = new int[n];
        if(k==0)
        return ans;
        else if(k>0){
            for(int i=0;i<n;i++){
                int sum=0;
                for(int j=1;j<=k;j++){
                    sum+=nums[(i+n+j)%n];
                }
                ans[i] = sum;
            }
        }
        else{
            for(int i=0;i<n;i++){
                int sum=0;
                for(int j=1;j<=-1*k;j++){
                    sum+=nums[(i+n-j)%n];
                }
                ans[i] = sum;
            }
        }
        return ans;
    }
}