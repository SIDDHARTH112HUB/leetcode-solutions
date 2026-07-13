class Solution {
    public int numJewelsInStones(String j, String s) {
        Set<Character> st = new HashSet<>();
        for(char c:j.toCharArray()){
                st.add(c);
        }
        int ans=0;
        for(char c:s.toCharArray()){
            if(st.contains(c))
            ans++;
        }
        return ans;
    }
}