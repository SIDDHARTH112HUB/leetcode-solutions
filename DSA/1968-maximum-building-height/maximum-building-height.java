import java.util.*;

class Solution {
    public int maxBuilding1(int n, int[][] restrictions) {
        // Step 1: initialize res[] with very large values
        int[] res = new int[n + 1]; // 1-indexed for convenience
        Arrays.fill(res, Integer.MAX_VALUE);

        // Step 2: apply given restrictions
        res[1] = 0; // building 1 must be height 0
        for (int[] t : restrictions) {
            res[t[0]] = t[1];
        }

        // Step 3: forward pass (left to right)
        int[] lmax = new int[n + 1];
        lmax[1] = 0;
        for (int i = 2; i <= n; i++) {
            lmax[i] = Math.min(lmax[i - 1] + 1, res[i]);
        }

        // Step 4: backward pass (right to left)
        int[] rmax = new int[n + 1];
        rmax[n] = res[n] == Integer.MAX_VALUE ? 1000000000 : res[n];
        for (int i = n - 1; i >= 1; i--) {
            rmax[i] = Math.min(res[i], rmax[i + 1] + 1);
        }

        // Step 5: combine both passes
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int h = Math.min(lmax[i], rmax[i]);
            ans = Math.max(ans, h);
        }

        return ans;
    }
    public int maxBuilding(int n, int[][] restrictions) {
        // Step 1: collect restrictions
        List<int[]> rs = new ArrayList<>();
        rs.add(new int[]{1, 0});
        for (int[] r : restrictions) rs.add(r);
        rs.add(new int[]{n, (int)1e9});
        rs.sort((a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: forward pass
        for (int i = 1; i < rs.size(); i++) {
            int[] prev = rs.get(i - 1), cur = rs.get(i);
            cur[1] = Math.min(cur[1], prev[1] + cur[0] - prev[0]);
        }

        // Step 3: backward pass
        for (int i = rs.size() - 2; i >= 0; i--) {
            int[] next = rs.get(i + 1), cur = rs.get(i);
            cur[1] = Math.min(cur[1], next[1] + next[0] - cur[0]);
        }

        // Step 4: compute max peak between restrictions
        int ans = 0;
        for (int i = 0; i < rs.size() - 1; i++) {
            int[] a = rs.get(i), b = rs.get(i + 1);
            int ia = a[0], ha = a[1];
            int ib = b[0], hb = b[1];
            ans = Math.max(ans, ha + (hb - ha + ib - ia) / 2);
        }

        return ans;
    }
}
