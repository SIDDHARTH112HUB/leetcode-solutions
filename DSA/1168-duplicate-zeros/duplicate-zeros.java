class Solution {
    public void duplicateZeros(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for(int i:arr){
            if(i==0){
                ans.add(0);
                ans.add(0);
            }
            else{
                ans.add(i);
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=ans.get(i);
        }
        //arr= ans.stream().mapToInt(Integer::intValue).toArray();
    }
}