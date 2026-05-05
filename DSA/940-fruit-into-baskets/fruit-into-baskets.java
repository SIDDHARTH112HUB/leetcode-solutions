class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> temp = new HashMap<>();
        int ans=0;
        int i=0,j=0;
        while(j<fruits.length){
            int c = fruits[j];
            temp.merge(c,1,Integer::sum);   
            while(temp.size()>2){
                int t= fruits[i];
                temp.computeIfPresent(t,(k,v)->(v>1)?v-1:null);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}