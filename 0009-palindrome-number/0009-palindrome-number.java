class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else{
            long z=0;
            int y=x;
            while(x>0){
                z=z*10+ (x%10);
                x/=10;
            }
            if (y==z)
                return true;
            else 
                return false;
        }
    }
}