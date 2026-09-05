class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            Arrays.sort(grid[i]);
        }
        int ans=0;
        for(int j=0;j<grid[0].length;j++){
            int a = grid[0][j];
            for(int i=0;i<grid.length;i++){
                a = Math.max(a,grid[i][j]);
            }
            ans+=a;
        }
        return ans;
    }
}