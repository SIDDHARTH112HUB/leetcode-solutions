class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                image[i][j] = Math.abs(image[i][j]-1);
            }
        }
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < image[row].length / 2; col++) {
                int temp = image[row][col];
                image[row][col] = image[row][image[row].length - 1 - col];
                image[row][image[row].length - 1 - col] = temp;
            }
        }
        return image;
    }
}