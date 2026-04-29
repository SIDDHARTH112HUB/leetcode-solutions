class Solution {
    public boolean checkInclusion(String pat, String txt) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : pat.toCharArray()) {
            counts.merge(c, 1, Integer::sum);
        }

        int i = 0, j = 0, ans = 0;
        int k = pat.length();
        int distinct = counts.size(); // number of distinct chars to match

        while (j < txt.length()) {
            char c = txt.charAt(j);
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) - 1);
                if (counts.get(c) == 0) distinct--; // matched one char fully
            }

            if (j - i + 1 == k) { // window size reached
                if (distinct == 0) return true; // all chars matched

                // slide window
                char left = txt.charAt(i);
                if (counts.containsKey(left)) {
                    if (counts.get(left) == 0) distinct++; // losing a full match
                    counts.put(left, counts.get(left) + 1);
                }
                i++;
            }
            j++;
        }
        return false;
    }
}
