class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c:t.toCharArray()){
            map.merge(c,1,Integer::sum);
        }
        int count = map.size();
        int i=0,j=0,ans=Integer.MAX_VALUE;
        String a="";
        while(j<s.length()){
            char z = s.charAt(j);
            map.computeIfPresent(z, (k, v) -> v - 1);
            if(map.getOrDefault(z,-1)==0){
                count--;
            }
            while(count==0){
                if(ans>j-i+1){
                    ans = j-i+1;
                    a = s.substring(i,j+1);
                }
                char y = s.charAt(i);
                map.computeIfPresent(y, (k, v) -> v + 1);
                if(map.getOrDefault(y,-1)==1){
                    count++;
                }
                i++;
            }
            j++;
        }
        return a;
    }
}
