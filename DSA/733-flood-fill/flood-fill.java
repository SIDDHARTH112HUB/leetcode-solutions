class Solution {
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    // public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    //     int m = image.length;
    //     int n = image[0].length;

    //     int org = image[sr][sc];
    //     image[sr][sc] = color;
    //     // Explore neighbors
    //     for (int[] d : DIRS) {
    //         int nr = sr + d[0];
    //         int nc = sc + d[1];
    //         dfs(image, nr, nc, color, org);
    //     }
    //     return image;
    // }
    // public void dfs(int[][] image, int sr, int sc, int color, int org) {
    //     int m = image.length;
    //     int n = image[0].length;

    //     // Boundary + visited check
    //     if (sr < 0 || sc < 0 || sr >= m || sc >= n || image[sr][sc]==color ) {
    //         return;
    //     }

    //     if(image[sr][sc]==org )
    //         image[sr][sc] = color;
    //     else 
    //         return;
    //     // Do your work here (e.g., count, mark, collect)
    //     // Example: System.out.println("Visiting: " + r + "," + c);

    //     // Explore neighbors
    //     for (int[] d : DIRS) {
    //         int nr = sr + d[0];
    //         int nc = sc + d[1];
    //         dfs(image,nr, nc, color, org);
    //     }
    // }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int orgColor = image[sr][sc];
        if (orgColor == newColor) return image; // no work needed
        dfs(image, sr, sc, orgColor, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int orgColor, int newColor) {
        int m = image.length, n = image[0].length;
        
        // boundary + mismatch check
        if (r < 0 || c < 0 || r >= m || c >= n || image[r][c] != orgColor) {
            return;
        }
        
        // paint current cell
        image[r][c] = newColor;
        
        // explore neighbors
        for (int[] d : DIRS) {
            dfs(image, r + d[0], c + d[1], orgColor, newColor);
        }
    }


}