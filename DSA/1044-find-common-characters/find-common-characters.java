class Solution {
    public List<String> commonChars(String[] words) {
        Map<Character,Integer> mp = new HashMap<>();
        String word = words[0];
        for(char c: word.toCharArray()){
           mp.merge(c,1,Integer::sum); 
        }
        for(int i=1;i<words.length;i++){
            Map<Character,Integer> mp1 = new HashMap<>();
            for(char c: words[i].toCharArray()){
                mp1.merge(c,1,Integer::sum); 
            }
            mp.forEach((c, v) -> {
                if (mp1.containsKey(c)) {
                    mp.put(c, Math.min(v, mp1.get(c)));
                }
            });

            // 2. Remove keys that aren't in mp1
            mp.entrySet().removeIf(entry -> !mp1.containsKey(entry.getKey()));
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            char c = entry.getKey();
            int v = entry.getValue();
            for(int i=0;i<v;i++){
                ans.add(String.valueOf(c));
            }
        }
        return ans;
    }
}