class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int left = 0, right = 0;
        // Track frequency of a, b, c
        int[] freq = new int[3];
        int total = 0;

        while (right < len) {
            // Add character at right pointer to frequency array
            char curr = s.charAt(right);
            freq[curr - 'a']++;

            // While we have all required characters
            while (hasAllChars(freq)) {
                // All substrings from current window to end are valid
                // Add count of these substrings to result
                total += len - right;

                // Remove leftmost character and move left pointer
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                left++;
            }

            right++;
        }

        return total;

    }
    private boolean hasAllChars(int[] freq) {
        // Check if we have at least one of each character
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
    public int numberOfSubstrings1(String s) {
        int len = s.length();
        // Track last position of a, b, c
        int[] lastPos = { -1, -1, -1 };
        int total = 0;

        for (int pos = 0; pos < len; pos++) {
            // Update last position of current character
            lastPos[s.charAt(pos) - 'a'] = pos;

            // Add count of valid substrings ending at current position
            // If any character is missing, min will be -1
            // Else min gives leftmost required character position
            total += 1 + Math.min(lastPos[0], Math.min(lastPos[1], lastPos[2]));
        }

        return total;
    }
}