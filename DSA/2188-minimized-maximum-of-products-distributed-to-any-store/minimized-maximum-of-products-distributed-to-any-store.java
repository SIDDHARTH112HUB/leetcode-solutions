class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int end =0;
        for(int i:quantities){
            end= Math.max(i,end);
        }
        int start=1;
        int ans=0;
        while(start<=end){
            int mid= start+ (end-start)/2;
            if(isValid(quantities,mid,n)){
                ans=mid;
                end=mid-1;
            }
            else
            start=mid+1;
        }
        return ans;
    }
    boolean isValid(int []q, int k, int h){
        long hours = 0;
        
        for (int p : q) {
            hours += (p + k - 1) / k;  // ceil
        }
        
        return hours <= h;
    }
}