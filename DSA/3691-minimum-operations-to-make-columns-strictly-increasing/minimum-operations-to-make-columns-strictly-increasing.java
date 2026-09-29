class Solution {
    public int minimumOperations(int[][] grid) {
        int ans =0;
        for(int j=0;j<grid[0].length;j++){
            int c = grid[0][j];
            for(int i=1;i<grid.length;i++){
                c = Math.max(c+1,grid[i][j]);
                ans+=c-grid[i][j];
            }
        }
        return ans;
    }
}