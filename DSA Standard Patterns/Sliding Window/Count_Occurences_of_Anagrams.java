// User function Template for Java

//M1  -  O(n*k) time and O(k) space

import java.util.*;

class Solution {
    int search(String pat, String txt) {
        int k = pat.length();
        int n = txt.length();
        int ans = 0;

        // Frequency map for pattern
        Map<Character, Integer> countPat = new HashMap<>();
        for (char c : pat.toCharArray()) {
            countPat.merge(c, 1, Integer::sum);
        }

        // Sliding window frequency map for text
        Map<Character, Integer> countMap = new HashMap<>();

        int i = 0;
        for (int j = 0; j < n; j++) {
            char c = txt.charAt(j);
            countMap.merge(c, 1, Integer::sum);

            // Maintain window size = k
            if (j - i + 1 == k) {
                // Compare maps
                if (countMap.equals(countPat)) {
                    ans++;
                }

                // Remove leftmost char from window
                char left = txt.charAt(i);
                countMap.put(left, countMap.get(left) - 1);
                if (countMap.get(left) == 0) {
                    countMap.remove(left);
                }
                i++;
            }
        }
        return ans;
    }

    //M2 - Optimized with distinct count
    
    int search1(String pat, String txt) {
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
                if (distinct == 0) ans++; // all chars matched

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
        return ans;
    }
}
