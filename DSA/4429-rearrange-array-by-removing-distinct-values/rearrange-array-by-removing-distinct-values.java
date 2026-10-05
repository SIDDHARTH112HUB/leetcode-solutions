class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] a = new int[101];
        for(int i:nums){
            a[i]++;
        }
        int i=0;
        while(i<nums.length){
            int j=1;
            while(j<=100){
                if(a[j]>0){
                    nums[i++]=j;
                    a[j]--;
                }
                j++;
            }
        }
        return nums;
    }
}