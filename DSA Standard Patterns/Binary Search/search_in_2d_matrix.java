class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        
        int start = 0, end = numRows*numCols - 1;
        
        while(start <= end) {
            int mid = (start+end)/2;
            int midValue = matrix[mid/numCols][mid%numCols];
            if(target == midValue) {
                return true;
            } else if (target < midValue) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        
        return false;
    }
}
