import java.util.Scanner;

class MinimumDifferenceElementInSortedArray {

    private static int binarySearchMinDifference(int[] a, int target) {
        int n = a.length;

        if (target < a[0])
            return a[0];
        if (target > a[n - 1])
            return a[n - 1];

        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (target == a[mid]) {
                return a[mid];
            } else if (target < a[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        /*
           At the end of the while loop, 
           a[start] is the ceiling of target (Smallest number greater than target), and 
           a[end] is the floor of target (Largest number smaller than target).
           
           Return the element whose difference with target is smaller
         */
        if ((a[start] - target) < (target - a[end]))
            return a[start];
        return a[end];
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = keyboard.nextInt();
        }
        int target = keyboard.nextInt();
        keyboard.close();

        System.out.printf("MinimumDifferenceElementWith(%d) = %d%n", target, binarySearchMinDifference(a, target));
    }
}