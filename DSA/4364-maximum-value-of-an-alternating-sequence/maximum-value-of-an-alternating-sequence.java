class Solution {
    public long maximumValue(int n, int s, int m) {
        if (n <= 1) return s;

        long k = n / 2;

        // Starting from s: k upward steps of +m, and (k - 1) downward steps of -1
        return (long) s + m + (k - 1) * (m - 1L);

    }
}