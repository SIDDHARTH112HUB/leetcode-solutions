class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.append(String.format("%8s", Integer.toBinaryString(c & 0xFF)).replace(' ', '0'));
        }
        char[] cr = sb.toString().toCharArray();
        int i =0;
        int j = cr.length-1;
        while(i<j){
            if(cr[i]!=cr[j])
            return false;
            i++;
            j--;
        }
        return true;
    }
}