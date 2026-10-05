class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total = 0;
        for(int i:apple){
            total+=i;
        }
        int ans =0;
        int t=0;
        int i=0;
        Integer[] c = Arrays.stream(capacity).boxed().toArray(Integer[]::new);
        Arrays.sort(c, Collections.reverseOrder());
        while(t<total && i<c.length){
            t+=c[i];
            i++;
            ans++;
        }
        return ans;
    }
}