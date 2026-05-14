class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> temp = new HashMap<>();
        
        int i=0,j=0;
        while(j<nums.length){
            int c = nums[j];
            temp.merge(c,1,Integer::sum);   
            while(j-i+1==k){
                int result = temp.entrySet().stream()
                                // 1. Sort by value (desc), then by key (desc)
                                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()
                                    .thenComparing(Map.Entry.<Integer, Integer>comparingByKey().reversed()))
                                // 2. Limit to top X (or total size, whichever is lower)
                                .limit(x)
                                // 3. Multiply value with itself (or any other logic) and sum
                                .mapToInt(entry -> entry.getKey() * entry.getValue())
                                .sum();
                ans.add(result);
                int t= nums[i];
                temp.computeIfPresent(t,(k1,v)->(v>1)?v-1:null);
                i++;
            }
            j++;
        }
        int[] intArray = ans.stream().mapToInt(Integer::intValue).toArray();
        return intArray;
    }
}