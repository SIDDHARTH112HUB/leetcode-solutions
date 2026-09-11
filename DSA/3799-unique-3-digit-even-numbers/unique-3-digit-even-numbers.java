class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        // Generate all permutations of size 3
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && j != k && i != k) {  // Ensure distinct indices
                        int hundreds = digits[i];
                        int tens = digits[j];
                        int ones = digits[k];
                        int number = hundreds * 100 + tens * 10 + ones;

                        // Check if it's a three-digit number and even
                        if (hundreds != 0 && ones % 2 == 0) {
                            uniqueNumbers.add(number);
                        }
                    }
                }
            }
        }

        return uniqueNumbers.size();


    }
}