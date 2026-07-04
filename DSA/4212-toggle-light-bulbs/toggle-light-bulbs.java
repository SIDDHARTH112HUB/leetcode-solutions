class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int arr[] =new int[101]; 
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<bulbs.size();i++){
            int a =bulbs.get(i);
            if(arr[a]==1){
                arr[a]=0;
            }
            else
            arr[a]=1;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1)
            ans.add(i);
        }
        return ans;
    }
}