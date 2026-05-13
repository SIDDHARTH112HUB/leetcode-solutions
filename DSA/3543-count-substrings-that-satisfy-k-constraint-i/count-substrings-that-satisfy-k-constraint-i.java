class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isValid(s,i,j,k))
                ans++;
            }
        }
        return ans;
    }
    public boolean isValid(String s, int i, int j, int k){
        int count0=0;
        int count1=0;
        for(;i<=j;i++){
            if(s.charAt(i)=='0'){
                count0++;
            }
            else
            count1++;
        }
        return count0<=k || count1<=k;
    }
}