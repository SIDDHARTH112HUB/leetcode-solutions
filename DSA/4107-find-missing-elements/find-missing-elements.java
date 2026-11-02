class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int mi = nums[0];
        int ma = nums[0];

        for(int i:nums){
            mi = Math.min(i,mi);
            ma = Math.max(i,ma);
        }
        int []n = new int[ma+1];
        List<Integer> ans = new ArrayList<>();
        for(int i:nums){
            n[i]++;
        }
        for(int i=mi;i<=ma;i++){
            if(n[i]==0)
            ans.add(i);
        }
        return ans;
    }
}