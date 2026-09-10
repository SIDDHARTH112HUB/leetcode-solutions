import java.util.Arrays;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        
        // If we only have 1 bag, or if bags equal the number of marbles, 
        // there is only one way to distribute them. Max - Min = 0.
        if (k == 1 || k == n) {
            return 0;
        }

        // Array to store the sum of adjacent pairs (the "cut" points)
        int[] pairs = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            pairs[i] = weights[i] + weights[i + 1];
        }

        // Sort the pairs to easily pick the smallest and largest
        Arrays.sort(pairs);

        long minScore = 0;
        long maxScore = 0;

        // The first and last elements are always included in every configuration.
        // We only need to sum the (k - 1) smallest and largest cut points.
        for (int i = 0; i < k - 1; i++) {
            minScore += pairs[i];
            maxScore += pairs[n - 2 - i]; // n - 2 is the last index of the pairs array
        }

        return maxScore - minScore;
    }
}