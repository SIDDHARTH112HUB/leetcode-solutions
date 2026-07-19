// class Solution {
//     public String shortestCompletingWord(String licensePlate, String[] words) {
//         String s ="";
//         for(char c:licensePlate.toCharArray()){
//             if(Character.isLetter(c)){
//                 s+=Character.toLowerCase(c);
//             }
//         }
//         System.out.println(s);
//         int ans= Integer.MAX_VALUE;
//         String a="";
//         for(String w:words){
//             if(isAnagram(s,w)){
//                 if(w.length()<ans){
//                     ans = w.length();
//                     a =w;
//                 }
//             }
//         }
//         return a;
//     }
//     public boolean isAnagram(String s, String t) {
//         if (s.length() > t.length()) return false;

//         Map<Character,Integer> mp = new HashMap<>();
//         for (char c : s.toCharArray()) {
//             mp.merge(c, 1, Integer::sum);
//         }

//         for (char c : t.toCharArray()) {
//             if (mp.containsKey(c))
//             {   
//                 mp.put(c, mp.get(c) - 1);
//             }
//         }

//         // All counts should be more than 1
//         for (int val : mp.values()) {
//             if (val > 0) return false;
//         }
//         return true;
//     }
// }

import java.util.*;

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // Count required letters from licensePlate
        int[] need = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                need[Character.toLowerCase(c) - 'a']++;
            }
        }

        String ans = "";
        int minLen = Integer.MAX_VALUE;

        for (String w : words) {
            if (completes(need, w)) {
                if (w.length() < minLen) {
                    minLen = w.length();
                    ans = w;
                }
            }
        }
        return ans;
    }

    private boolean completes(int[] need, String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[Character.toLowerCase(c) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] < need[i]) return false;
        }
        return true;
    }
}
