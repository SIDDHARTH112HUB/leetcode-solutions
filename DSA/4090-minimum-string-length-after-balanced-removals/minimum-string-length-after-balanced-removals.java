class Solution {
    public int minLengthAfterRemovals(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == 'a'){
                count ++;
            }
            else 
                count --;
        }

        return Math.abs(count);
    }
}