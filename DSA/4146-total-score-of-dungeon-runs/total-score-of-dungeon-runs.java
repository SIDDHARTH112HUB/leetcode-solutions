import java.util.*;

class Solution {
    public long totalScore(int initialHealth, int[] damage, int[] requirement) {
        int n = damage.length;
        long totalScore = 0;

        // Build prefix sums of damage
        long[] prefixDamage = new long[n + 1];
        long cumulativeDamage = 0;
        for (int i = 0; i < n; i++) {
            cumulativeDamage += damage[i];
            prefixDamage[i + 1] = cumulativeDamage;
        }

        // For each room, calculate how many starting points are valid
        for (int roomIndex = 0; roomIndex < n; roomIndex++) {
            // Threshold health needed before entering this room
            long requiredPrefix = prefixDamage[roomIndex + 1] 
                                + requirement[roomIndex] 
                                - initialHealth;

            // Find the smallest prefix index where prefixDamage >= requiredPrefix
            int startIndex = lowerBound(prefixDamage, requiredPrefix);

            // Only count valid starts that are before or at this room
            if (startIndex <= roomIndex) {
                totalScore += (roomIndex - startIndex + 1);
            }
        }

        return totalScore;
    }

    // Equivalent of C++ lower_bound
    private int lowerBound(long[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
