class Solution {
    public int splitNum(int num) {
        int[] nums = new int[10];
        int num1 = 0;
        int num2 = 0;

        while (num != 0) {
            nums[num % 10]++;
            num /= 10;
        }

        int currentNumber = 1;

        for (int i = 0; i < 10; i++) {
            int count = nums[i];

            while (count != 0) {

                if (currentNumber == 1) {
                    num1 = num1 * 10 + i;
                } else {
                    num2 = num2 * 10 + i;
                }

                currentNumber *= -1;
                count--;
            }
        }

        return num1 + num2;
    }
}