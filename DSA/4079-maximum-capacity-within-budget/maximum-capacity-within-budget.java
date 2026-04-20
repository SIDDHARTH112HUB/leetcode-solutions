import java.util.Arrays;

class Solution {
    public int maxCapacity(int[] cos, int[] cap, int budget) {
        int n = cos.length;
        
        // 1. Correctly pair cost and capacity (n rows, 2 columns)
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = cos[i]; // Cost
            arr[i][1] = cap[i]; // Capacity
        }
        
        // Sort machines by cost in ascending order
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        // 2. Correctly track the prefix max of the CAPACITIES
        int[] preMax = new int[n];
        int maxCapSoFar = 0;
        for (int i = 0; i < n; i++) {
            maxCapSoFar = Math.max(maxCapSoFar, arr[i][1]);
            preMax[i] = maxCapSoFar;
        }
        
        int res = 0; // Initialize to 0 as per problem requirements
        
        for (int i = 0; i < n; i++) {
            int currentCost = arr[i][0];
            int currentCap = arr[i][1];
            
            // Total cost must be STRICTLY less than the budget
            if (currentCost >= budget) break; 
            
            // 5. Case A: We pick this machine alone
            res = Math.max(res, currentCap);
            
            // 3. Case B: We pair it with a previously seen machine
            int targetRemainingCost = budget - currentCost; 
            
            // Look for the threshold index among machines cheaper than the current one
            int j = lowerBound(arr, i, targetRemainingCost);
            
            // 4. If j > 0, it means machines at indices 0 through j-1 are valid
            if (j > 0) {
                res = Math.max(res, currentCap + preMax[j - 1]);
            }
        }
        
        return res;
    }

    private int lowerBound(int[][] arr, int high, int target) {
        int low = 0;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid][0] < target) { // Make sure to check the cost!
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}