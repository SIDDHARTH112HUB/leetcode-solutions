class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int l =x,r = x+k-1;
        while(l<r){
            for(int j=y;j<y+k;j++){
                int a= grid[l][j];
                grid[l][j] = grid[r][j];
                grid[r][j] = a;
            }
            l++;
            r--;
        }
        return grid;
    }
}