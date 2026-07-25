class Solution {
    public String toGoatLatin(String sentence) {
        String[] parts = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        int i=1;
        for(String s:parts){
            if(startsWithVowel(s)){
                s+="ma";
            }
            else{
                s=s.substring(1)+s.charAt(0)+"ma";
            }
            s=s + "a".repeat(i);
            i++;
            if(sb.length()==0){
                sb.append(s);
            }
            else{
                sb.append(" ");
                sb.append(s);
            }
        }
        return sb.toString();
    }
    public boolean startsWithVowel(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        
        char firstChar = word.charAt(0);
        switch (firstChar) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
            case 'A': case 'E': case 'I': case 'O': case 'U':
                return true;
            default:
                return false;
        }
    }
}