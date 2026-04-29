class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> temp = new HashMap<>();
        int ans=0;
        int i=0,j=0;
        while(j<s.length()){
            char c = s.charAt(j);
            temp.merge(c,1,Integer::sum);   
            while(j-i+1>temp.size()){
                char t= s.charAt(i);
                temp.computeIfPresent(t,(k,v)->(v>1)?v-1:null);
                i++;
            }
            ans = Math.max(ans,temp.size());
            j++;
        }
        return ans;
    }
}
