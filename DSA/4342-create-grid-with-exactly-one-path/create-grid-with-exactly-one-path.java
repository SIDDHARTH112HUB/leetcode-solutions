class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        for(int i=0;i<m;i++){
            String a ="";
            for(int j=0;j<n;j++){
                if(i==0 || j==n-1){
                    a+='.';
                }
                else{
                    a+="#";
                }
            }
            ans[i]=a;
        }
        return ans;
    }
}