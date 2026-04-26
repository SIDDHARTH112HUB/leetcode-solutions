// class Solution {
//     public int incremovableSubarrayCount(int[] nums) {
//         int ans=0;
//         for(int i=0;i<nums.length;i++){
//             for(int j=i;j<nums.length;j++)
//             {
//                 if(check(nums,i,j))
//                 ans++;
//             }
//         }
//         return ans;
//     }
//     private boolean check(int[] nums,int i,int j){
//         int []arr = new int [nums.length-(j-i+1)];
//         int t=0;
//         int k=0;
//         //System.out.println("i : " +i + " j : " +j);
        
//         while(t<nums.length){
//             if(t<i || t>j){
//                 arr[k]=nums[t];
//                 k++;
//             }
//             t++;
//         }
//         k=0;
//         while(k<arr.length-1){
//             if(arr[k]>=arr[k+1])
//             {
//                 //System.out.println(false);
//                 return false;
//             }
//             k++;
//         }

//         //System.out.println("true");
//         return true;
//     }
// }

class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        boolean[] prefixInc = new boolean[n];
        boolean[] suffixInc = new boolean[n];

        // Precompute prefix increasing
        prefixInc[0] = true;
        for (int i = 1; i < n; i++) {
            prefixInc[i] = prefixInc[i - 1] && nums[i - 1] < nums[i];
        }

        // Precompute suffix increasing
        suffixInc[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            suffixInc[i] = suffixInc[i + 1] && nums[i] < nums[i + 1];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                boolean leftOk = (i == 0) || prefixInc[i - 1];
                boolean rightOk = (j == n - 1) || suffixInc[j + 1];
                boolean bridgeOk = (i == 0 || j == n - 1) || nums[i - 1] < nums[j + 1];

                if (leftOk && rightOk && bridgeOk) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

