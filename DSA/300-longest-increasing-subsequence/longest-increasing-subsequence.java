class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        List<Integer> tails = new ArrayList<>();
        
        for (int num : nums) {
            // Collections.binarySearch returns the index of num
            // or (-(insertion point) - 1) if not present
            int index = Collections.binarySearch(tails, num);
            
            // If not found, convert negative result to the actual insertion point
            if (index < 0) {
                index = -(index + 1);
            }
            
            if (index == tails.size()) {
                tails.add(num);
            } else {
                tails.set(index, num);
            }
        }
        
        return tails.size();
    }
}