class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ops = new ArrayList<>();
        int i=1;
        for(int k:target){
            while(i<k){
                ops.add("Push");
                ops.add("Pop");
                i++;
            }
            ops.add("Push");
            i++;
        }
        return ops;
    }
}