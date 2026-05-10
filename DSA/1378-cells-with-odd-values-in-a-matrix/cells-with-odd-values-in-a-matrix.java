class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        Map<Integer,Integer> rows = new HashMap<>();
        Map<Integer,Integer> cols = new HashMap<>();
        for(int[]d: indices){
            rows.merge(d[0],1,Integer::sum);
            cols.merge(d[1],1,Integer::sum);
        }
        int rodd =0;
        int revn =0;
        for (Map.Entry<Integer, Integer> entry : rows.entrySet()) {
            int c = entry.getKey();
            int v = entry.getValue();
            if(v%2==0)
            revn++;
            else
            rodd++;
        }
        int codd =0;
        int cevn =0;
        for (Map.Entry<Integer, Integer> entry : cols.entrySet()) {
            int c = entry.getKey();
            int v = entry.getValue();
            if(v%2==0)
            cevn++;
            else
            codd++;
        }
        int ans = rodd * (n - codd) + (m - rodd) * codd;
        return ans;
    }
}