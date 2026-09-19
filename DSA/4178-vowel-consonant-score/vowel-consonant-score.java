class Solution {
    public int vowelConsonantScore(String s) {
        int c=0,v=0;
        for(char ch:s.toCharArray()){
            if(Character.isLetter(ch)){
                if(isVowel(ch)){
                    v++;
                }
                else{
                    c++;
                }
            }
        }
        if(c>0){
            return v/c;
        }
        return 0;
    }
    public static boolean isVowel(char ch) {
        return switch (Character.toLowerCase(ch)) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }
}