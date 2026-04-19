import java.util.*;

class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long ans = 0;

        // prefix sums
        long[] pref = new long[n + 1];
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += damage[i];
            pref[i + 1] = s;
        }

        for (int i = 0; i < n; i++) {
            long t = pref[i + 1] + requirement[i] - hp;
            int ip = lowerBound(pref, t);
            if (ip <= i) {
                ans += (i - ip + 1);
            }
        }

        return ans;
    }

    // Java version of C++ lower_bound
    private int lowerBound(long[] arr, long target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
