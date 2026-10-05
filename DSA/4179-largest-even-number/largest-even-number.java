class Solution {
    public String largestEven(String s) {
        int i=s.length();
        while(i>0){
            if(s.charAt(i-1)=='2'){
                return s.substring(0,i);
            }
            i--;
        }
        return "";
    }
}