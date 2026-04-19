class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int end =0;
        for(int i:piles){
            end= Math.max(i,end);
        }
        int start=1;
        int ans=0;
        while(start<=end){
            int mid= start+ (end-start)/2;
            if(isValid(piles,mid,h)){
                ans=mid;
                end=mid-1;
            }
            else
            start=mid+1;
        }
        return ans;
    }
    boolean isValid(int []piles, int k, int h){
        long hours = 0;
        
        for (int p : piles) {
            hours += (p + k - 1) / k;  // ceil
        }
        
        return hours <= h;
    }
}
