class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character,Integer> mp1 = new HashMap<>();
        Map<Character,Integer> mp2 = new HashMap<>();
        for(char c:s.toCharArray()){
            mp1.merge(c,1,Integer::sum);
        }
        for(char c:t.toCharArray()){
            if(mp1.containsKey(c))
            mp2.merge(c,1,Integer::sum);
            else return false;
        }
        for(char c:mp1.keySet()){
            if(!mp2.containsKey(c) || !mp1.get(c).equals(mp2.get(c)))
            return false;
        }
        return true;

    }
}
