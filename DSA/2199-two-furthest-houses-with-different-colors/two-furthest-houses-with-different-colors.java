class Solution {
    public int maxDistance(int[] colors) {
        int [][] col = new int[101][2];
        for(int i=0;i<=100;i++)
        {
            col[i][0]=101;
            col[i][1] = -1;
        }
        for(int i=0;i<colors.length;i++){
            int j = colors[i];
            col[j][0] = Math.min(i,col[j][0] );
            col[j][1] = Math.max(i,col[j][1] );
        }
        int max =0;
        for(int i=0;i<=100;i++){
            for(int j=i+1;j<=100;j++){
                if(col[i][0]!=101 && col[j][0]!=101){
                    max = Math.max(Math.abs(col[i][0]-col[j][0]),max);
                    max = Math.max(Math.abs(col[i][0]-col[j][1]),max);
                    max = Math.max(Math.abs(col[i][1]-col[j][0]),max);
                    max = Math.max(Math.abs(col[i][1]-col[j][1]),max);
                }
            }
        }
        return max;
    }
}