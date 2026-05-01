class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[3]; // counts for 'a','b','c'
        int i = 0, ans = 0;

        for (int j = 0; j < n; j++) {
            count[s.charAt(j) - 'a']++;

            // shrink window until it still contains all 3 chars
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                ans += n - j; // every substring starting at i and ending >= j is valid
                count[s.charAt(i) - 'a']--;
                i++;
            }
        }
        return ans;
    }
}