class Solution {
    public String trimTrailingVowels(String s) {
        return s.replaceAll("(?i)[aeiou]+$", "");
    }
}