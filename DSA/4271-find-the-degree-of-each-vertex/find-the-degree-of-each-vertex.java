class Solution {
    public int[] findDegrees1(int[][] matrix) {
        Map<Integer, Set<Integer>>mp = buildTree(matrix);
        int [] ans = new int[matrix.length];
        for(int i=0;i<ans.length;i++){
            ans[i] = mp.getOrDefault(i, new HashSet<>()).size();
        }
        return ans;
    }
    public Map<Integer, Set<Integer>> buildTree(int[][] edges) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int i =0;i<edges.length;i++) {
            for(int j=0;j<edges.length;j++)
            {
                if(edges[i][j]==1){
                    int u = i;
                    int v = j;

                    // add u → v
                    adj.computeIfAbsent(u, k -> new HashSet<>()).add(v);
                    // add v → u (to-and-fro relation)
                    adj.computeIfAbsent(v, k -> new HashSet<>()).add(u);
                }
            }
            
        }

        return adj;
    }
    public int[] findDegrees(int[][] matrix) {
      int[]  degree=new int[matrix.length];  
      for(int i =0;i<matrix.length;i++){
        for(int j=i;j<matrix.length;j++){
            if(matrix[i][j]==1){
                degree[i]++;
                degree[j]++;
            }
        }
      }
      return degree;
    }
}