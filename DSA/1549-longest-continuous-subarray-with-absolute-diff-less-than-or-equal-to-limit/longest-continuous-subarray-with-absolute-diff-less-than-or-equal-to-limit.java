class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int i=0,j=0,ans=0;
        while(j<nums.length){
            int c = nums[j];
            map.merge(c,1,Integer::sum);
            while(map.lastKey()-map.firstKey()>limit){
                int c1= nums[i];
                map.computeIfPresent(c1,(k,v)->(v>1)?v-1:null);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}