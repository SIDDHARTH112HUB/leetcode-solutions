class Solution {
    public int longestSubarray1(int[] nums, int limit) {
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
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0, j = 0, ans = 0;

        while (j < nums.length) {
            // 1. Add the NEW element at index j to the map
            int incoming = nums[j];
            map.put(incoming, map.getOrDefault(incoming, 0) + 1);

            // 2. If the limit is exceeded, shrink the window from the left (i)
            while (map.lastKey() - map.firstKey() > limit) {
                int outgoing = nums[i];
                int count = map.get(outgoing);
                if (count == 1) {
                    map.remove(outgoing);
                } else {
                    map.put(outgoing, count - 1);
                }
                i++; // Shrink window
            }

            // 3. Update the maximum length found so far
            ans = Math.max(ans, j - i + 1);
            j++; // Expand window
        }
        return ans;
    }
}