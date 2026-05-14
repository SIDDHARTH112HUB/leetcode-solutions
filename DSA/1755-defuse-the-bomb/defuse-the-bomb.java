class Solution {
    public int[] decrypt1(int[] nums, int k) {
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

    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        if (k == 0) return result;
        // Define the initial window and initial sum
        int start = 1, end = k, sum = 0;
        // If k < 0, the starting point will be end of the array.
        if (k < 0) {
            start = code.length - Math.abs(k);
            end = code.length - 1;
        }
        for (int i = start; i <= end; i++) sum += code[i];
        // Scan through the code array as i moving to the right, update the window sum.
        for (int i = 0; i < code.length; i++) {
            result[i] = sum;
            sum -= code[(start) % code.length];
            sum += code[(end + 1) % code.length];
            start++;
            end++;
        }
        return result;
    }
}