public class lowerBound {
    private int findLowerBound(int[] arr, int high, int target) {
        int low = 0;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] < target) { // Make sure to check the cost!
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
}
