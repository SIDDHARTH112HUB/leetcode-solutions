class Solution {
    public int minimumIndex(int[] c, int s) {
        int ans= Integer.MAX_VALUE;
        int ansi=-1;
        for(int i=0;i<c.length;i++){
            if(c[i]>=s){
                if(ans>c[i]){
                    ans=c[i];
                    ansi=i;
                }
            }
        }
        return ansi;
    }
}