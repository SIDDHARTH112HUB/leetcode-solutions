class Solution {
    public int residuePrefixes(String str) {
        Set<Character> s = new HashSet<>();
        int ans = 0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            s.add(c);

            if((i+1)%3==s.size())
            ans++;
        }
        return ans;

    }
}