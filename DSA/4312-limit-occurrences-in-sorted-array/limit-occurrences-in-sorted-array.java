class Solution {
    public int[] limitOccurrences(int[] nums, int m) {
        List<Integer> ans = new ArrayList<>();
        int t=1;
        int k=nums[0];
        ans.add(k);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==k){
                t++;
            }
            else{
                k=nums[i];
                t=1;
            }
            if(t<=m){
                ans.add(k);
            }
        }
        return ans.stream()
                           .mapToInt(Integer::intValue) // unbox Integer to int
                           .toArray();
    }
}