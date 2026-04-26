class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++)
            {
                if(check(nums,i,j))
                ans++;
            }
        }
        return ans;
    }
    private boolean check(int[] nums,int i,int j){
        int []arr = new int [nums.length-(j-i+1)];
        int t=0;
        int k=0;
        //System.out.println("i : " +i + " j : " +j);
        
        while(t<nums.length){
            if(t<i || t>j){
                arr[k]=nums[t];
                k++;
            }
            t++;
        }
        k=0;
        while(k<arr.length-1){
            if(arr[k]>=arr[k+1])
            {
                //System.out.println(false);
                return false;
            }
            k++;
        }

        //System.out.println("true");
        return true;
    }
}