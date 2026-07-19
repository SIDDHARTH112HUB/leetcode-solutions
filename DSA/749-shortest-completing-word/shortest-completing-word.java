class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String s ="";
        for(char c:licensePlate.toCharArray()){
            if(Character.isLetter(c)){
                s+=Character.toLowerCase(c);
            }
        }
        System.out.println(s);
        int ans= Integer.MAX_VALUE;
        String a="";
        for(String w:words){
            if(isAnagram(s,w)){
                if(w.length()<ans){
                    ans = w.length();
                    a =w;
                }
            }
        }
        return a;
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() > t.length()) return false;

        Map<Character,Integer> mp = new HashMap<>();
        for (char c : s.toCharArray()) {
            mp.merge(c, 1, Integer::sum);
        }

        for (char c : t.toCharArray()) {
            if (mp.containsKey(c))
            {   
                mp.put(c, mp.get(c) - 1);
            }
        }

        // All counts should be more than 1
        for (int val : mp.values()) {
            if (val > 0) return false;
        }
        return true;
    }
}