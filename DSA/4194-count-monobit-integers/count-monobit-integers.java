class Solution {
    public int countMonobit(int n) {
        int ans=1;
        int a=1;
        while(a<=n){
            ans++;
            a=a<<1;
            a+=1;
        }
        return ans;
    }
}