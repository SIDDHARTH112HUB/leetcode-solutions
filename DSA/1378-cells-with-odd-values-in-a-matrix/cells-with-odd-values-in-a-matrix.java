class Solution {
    public int oddCells1(int m, int n, int[][] indices) {
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
    public int oddCells2(int m, int n, int[][] indices) {
        Map<Integer,Integer> rows = new HashMap<>();
        Map<Integer,Integer> cols = new HashMap<>();
        
        // Count increments for each row and column
        for(int[] d: indices){
            rows.merge(d[0], 1, Integer::sum);
            cols.merge(d[1], 1, Integer::sum);
        }

        // Count odd rows
        int rodd = 0;
        for (int i = 0; i < m; i++) {
            if (rows.getOrDefault(i, 0) % 2 != 0) rodd++;
        }

        // Count odd cols
        int codd = 0;
        for (int j = 0; j < n; j++) {
            if (cols.getOrDefault(j, 0) % 2 != 0) codd++;
        }

        // Correct formula: odd cells = rodd*(n-codd) + (m-rodd)*codd
        int ans = rodd * (n - codd) + (m - rodd) * codd;
        return ans;
    }
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];
        for (int[] idx : indices) {
            row[idx[0]]++;
            col[idx[1]]++;
        }
        int oddrows=0,oddcols=0;
        for(int r : row){
            if(r%2!=0)oddrows++;
        }
        for(int c : col){
            if(c%2!=0)oddcols++;
        }
        return oddrows * (n - oddcols) + (m - oddrows) * oddcols;
    }
}