class Solution {
    public int[] sortByReflection(int[] nums) {
        int[] sortedNumbers = Arrays.stream(nums)
                .boxed() // 1. Convert int to Integer objects
                .sorted((a, b) -> {
                    // --- YOUR CUSTOM LOGIC HERE ---
                    int revA = reverseBits(a);
                    int revB = reverseBits(b);
                    if (revA != revB) {
                        return Integer.compare(revA, revB);
                    }
                    return Integer.compare(a, b);
                })
                .mapToInt(Integer::intValue) // 2. Convert Integer back to primitive int
                .toArray(); // 3. Collect into a new int[]
        return sortedNumbers;
    }
    int reverseBits(int n){
        int rev = 0;
        while (n > 0) {
            rev = (rev << 1) | (n & 1);
            n >>= 1;
        }
        return rev;
    }
}