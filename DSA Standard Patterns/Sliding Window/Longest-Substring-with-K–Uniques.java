class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int ans =-1;
        Map<Character, Integer> mp = new HashMap<>();
        int i=0,j=0;
        while(j<s.length()){
            mp.merge(s.charAt(j),1,Integer::sum);
            if(mp.size()==k){
                ans= Math.max(ans, j-i+1);
            }
            while(mp.size()>k){
                char c = s.charAt(i);
                mp.computeIfPresent(c,(t,v)->(v>1)?v-1:null);
                i++;
            }
            j++;
        }
        return ans;
    }
}