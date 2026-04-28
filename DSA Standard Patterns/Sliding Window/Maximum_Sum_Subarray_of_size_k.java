class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int sum=0;
        int ans=Integer.MIN_VALUE;
        
        int i=0,j=0;
        while(j<arr.length){
            sum+=arr[j];
            if(j-i+1==k){
                ans =Math.max(ans,sum);
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return ans;
        
    }
}