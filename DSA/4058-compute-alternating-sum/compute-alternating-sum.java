class Solution {
    public int alternatingSum(int[] nums) {
        int k =1;
        int sum =0;
        for(int i:nums){
            sum+= i *k;
            k*=-1;
        }
        return sum;
    }
}