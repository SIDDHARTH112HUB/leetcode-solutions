class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] s = nums.clone(); // Copy the original array
        Arrays.sort(s);        // Sort the copy
        int deg =1;
        int temp=1;
        for(int i=1;i<s.length;i++){
            if(s[i]==s[i-1]){
                temp++;
                deg = Math.max(deg,temp);
            }
            else{
                temp=1;
            }
        }
        int ans =nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int i=0,j=0;
        while(j<nums.length){
            mp.merge(nums[j],1,Integer::sum);
            while(mp.size()>0&&mp.get(nums[j])>=deg){
                int c = nums[i];
                ans= Math.min(ans, j-i+1);
                mp.computeIfPresent(c,(t,v)->(v>1)?v-1:null);
                i++;
            }
            j++;
        }
        return ans;
    }
}