class Solution {
    public boolean isToeplitzMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<n;i++){
            int a = mat[0][i];
            int p=0,q=i;
            while(p<m&&q<n){
                if(mat[p][q]!=a)
                return false;
                p++;
                q++;
            }
        }
        for(int i=0;i<m;i++){
            int a = mat[i][0];
            int p=i,q=0;
            while(p<m&&q<n){
                if(mat[p][q]!=a)
                return false;
                p++;
                q++;
            }
        }
        return true;
    }
}