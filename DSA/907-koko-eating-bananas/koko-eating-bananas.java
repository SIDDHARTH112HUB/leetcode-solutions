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
    boolean isValid(int []p, int b, int h){
        long a=0;
        for(int i=0;i<p.length;i++){
            a+=p[i]/b;
            a+=p[i]%b==0?0:1;
        }
        return a<=h;
    }
}
