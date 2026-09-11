class Solution {
    public int totalNumbers1(int[] digits) {
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
    public int totalNumbers(int[] digits) {
        int[] freq=new int[10];
        for(int digit:digits){
            freq[digit]++;
        }
        int count=0;
        for(int i=1;i<=9;i++){
            if(freq[i]==0){
                continue;
            }
            freq[i]--;

            for(int j=0;j<=9;j++){
                if(freq[j]==0){
                    continue;
                }
                freq[j]--;

                for(int k=0;k<=8;k+=2){
                    if(freq[k]>0){
                        int number=i*100+j*10+k;
                        count++;
                    }
                }
                freq[j]++;
            }
            freq[i]++;
        }
        return count;
    }
}