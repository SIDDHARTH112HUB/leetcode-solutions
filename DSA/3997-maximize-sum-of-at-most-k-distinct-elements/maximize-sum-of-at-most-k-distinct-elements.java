class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> a = new HashSet<>();
        int i = nums.length-1;
        while(i>=0 && a.size()<k){
            
            if(nums[i]<=0)
            break;
            if(a.size()<k)
            a.add(nums[i]);
            i--;
        }
        int[] descendingArray = a.stream()
                .sorted(Comparator.reverseOrder()) // Sorts as Integer objects
                .mapToInt(Integer::intValue)       // Unboxes Integer to primitive int
                .toArray();                        // Creates the int[] array

        return descendingArray;
    }
}