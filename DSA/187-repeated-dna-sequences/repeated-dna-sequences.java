class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> mp = new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            //System.out.println("in for "+i);
            mp.merge(s.substring(i,i+10),1,Integer::sum);
        }
        List<String> ans =new ArrayList<>();
        for(Map.Entry<String, Integer>entry:mp.entrySet()){
            if(entry.getValue()>1){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}