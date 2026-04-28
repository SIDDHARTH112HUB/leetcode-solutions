class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int [][]a = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j] = avg(img,i,j,m,n);
            }
        }
        return a;
    }
    private int avg(int[][] img,int p, int q, int m, int n){
        int i1 =Math.max(p-1,0);
        
        int m1 = Math.min(m,p+2);
        int n1 = Math.min(n,q+2);
        int sum=0;
        int count =0;
        
  
        for(;i1<m1;i1++){
            int j1 =Math.max(q-1,0);
            for(;j1<n1;j1++){
                //System.out.println(" i1 :"+i1+" j1 :"+j1+" m1 :"+m1+" n1 :"+n1);
                sum+=img[i1][j1];
                count++;
            }
        }
        //System.out.println(" sum :"+sum+" count :"+count);
        return sum/count;
    }
}