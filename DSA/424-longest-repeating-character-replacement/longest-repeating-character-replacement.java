class Solution {
      // M1 
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> temp = new HashMap<>();
        int ans=0;
        int i=0,j=0;
        while(j<s.length()){
            char c = s.charAt(j);
            temp.merge(c,1,Integer::sum);   
            while(!notGood(temp,k)){
                char t= s.charAt(i);
                temp.computeIfPresent(t,(key,v)->(v>1)?v-1:null);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
    public boolean notGood(Map<Character, Integer> map,int k) {
        int max = Integer.MIN_VALUE;
        int sum=0;
        for (Integer val : map.values()) {
            max=Math.max(val,max);
            sum+=val;
        }
        sum -= max;
        return sum<=k;
    }

    //M2 
    public int characterReplacement1(String s, int k) {
        int[] count = new int[26];

        int left = 0;
        int max = 0;
        int maxLength = 0;
        for(int right = 0; right < s.length(); right++){
            count[s.charAt(right) - 'A']++;
            max = Math.max(max, count[s.charAt(right) - 'A']);
            if(right - left + 1 - max > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left +1);
        }

        return maxLength;

    }
      
}