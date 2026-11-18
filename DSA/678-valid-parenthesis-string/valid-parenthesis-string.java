class Solution {
    int [][]dp ;
    public boolean checkValidString(String s) {
        int min=0,max=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                min ++;
                max ++;
            }
            else if(c==')'){
                min--;
                max--;
            }
            else{
                min-=1;
                max++;
            }
            if(max<0)
            return false;
            if(min<0)
            min=0;
        }
        return min==0;
    }
    boolean isValid(String s, int i, int cnt){
        if(cnt<0)
        {
            return false;
        }
        if(dp[i][cnt]!=0){
            return dp[i][cnt]==1;
        }
        if(i== s.length() && cnt!=0){
            dp[i][cnt] =2;
            return false;
        }
        if(i==s.length() && cnt==0){
            dp[i][cnt] =2;
            return true;
        }
        boolean t = false;
        if(s.charAt(i)=='('){
            t= isValid(s,i+1,cnt+1);
        }
        else if(s.charAt(i)==')'){
            t= isValid(s,i+1,cnt-1);
        }
        else{
            t= isValid(s,i+1,cnt) || isValid(s,i+1,cnt-1) || isValid(s,i+1,cnt+1);
        }
        if(t==false){
            dp[i][cnt] = 2;
        }
        else{
            dp[i][cnt] = 1;
        }
        return t;
    }
}