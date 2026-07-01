class Solution {
    public int firstUniqueEven(int[] nums) {
        int []nu = new int[100];
        for(int i:nums){
            nu[i-1]++;
        }
        for(int i:nums){
            if(nu[i-1]==1 && i%2==0)
            return i;
        }
        return -1;
    }
}