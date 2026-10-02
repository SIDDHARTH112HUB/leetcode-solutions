class Solution {
    public int minimumPushes(String word) {
        int l = word.length();
        int ans = 0;
        if(l<=8)
        return l;
        ans+=8;
        l-=8;
        if(l<=8){
            ans+= 2*l;
            return ans;
        }
        ans+= 2*8;
        l-=8;
        if(l<=8){
            ans+= 3*l;
            return ans;
        }
        ans+= 3*8;
        l-=8;
        if(l<=8){
            ans+= 4*l;
            return ans;
        }
        return ans;
    }
}