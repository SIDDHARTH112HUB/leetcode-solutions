class Solution {
    public int[][] cyclicShift1(int n, int[][] grid, int[] rowShift, int[] colShift) {
        for(int i=0;i<rowShift.length;i++){
            rotateLeft(grid[i],rowShift[i]);
        }
        for(int i=0;i<colShift.length;i++){
            rotateTop(grid,i,colShift[i]);
        }
        return grid;
    }
    public static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handles cases where k is greater than array length
        if(k==0)
        return;
        reverse(arr, 0, k - 1);     // Reverse the first k elements
        reverse(arr, k, n - 1);     // Reverse the remaining elements
        reverse(arr, 0, n - 1);     // Reverse the whole array
    }
    public static void rotateTop(int[][] arr,int i, int k) {
        int n = arr.length;
        k = k % n; // Handles cases where k is greater than array length
        if(k==0)
        return;
        reverseCol(arr, i, 0, k - 1);     // Reverse the first k elements
        reverseCol(arr, i, k, n - 1);     // Reverse the remaining elements
        reverseCol(arr, i, 0, n - 1);     // Reverse the whole array
    }
    private static void reverseCol(int[][] arr,int i, int start, int end) {
        while (start < end) {
            int temp = arr[start][i];
            arr[start][i] = arr[end][i];
            arr[end][i] = temp;
            start++;
            end--;
        }
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] temp = new int[n][n];
        int[][] ans = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int newCol = (j - rowShift[i] + n) % n;
                temp[i][newCol] = grid[i][j];
            }
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int newRow = (i - colShift[j] + n) % n;
                ans[newRow][j] = temp[i][j];
            }
        }

        return ans;
    }
}