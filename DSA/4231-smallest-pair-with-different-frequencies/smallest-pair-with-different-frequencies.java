class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int num[] = new int [101];
        for(int i:nums){
            num[i]++;
        }
        int x=-1,y=-1;
        for(int i=1;i<num.length;i++){
            if(num[i]>0){
                x=i;
                int f =num[i];
                i++;
                for(;i<num.length;i++){
                    if(num[i]>0 && num[i]!=f){
                        int[] arr = {x,i};
                        return arr;
                    }
                } 
            }
        }
        int[] arr = {-1,-1};
        return arr;
    }
}