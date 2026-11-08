class Solution {
    public int[] decimalRepresentation(int n) {
        int i=1;
        List<Integer> ans = new ArrayList<>();
        while(n>0){
            int d = n%10;
            n=n/10;
            d = d*i;
            i=i*10;
            if(d!=0){
                ans.add(0,d);
            }
        }
        int[] primitiveArray = ans.stream()
                                   .mapToInt(Integer::intValue)
                                   .toArray();
                                   
        return primitiveArray;
    }
}