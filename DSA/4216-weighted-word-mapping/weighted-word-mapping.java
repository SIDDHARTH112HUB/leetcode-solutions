class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans ="";
        for(String s:words){
            int a=0;
            for(char c:s.toCharArray()){
                a+=weights[c-'a'];
            }
            a=a%26;
            a=26-a-1;
            ans+=(char) ('a'+a);
        }
        return ans; 
    }
}