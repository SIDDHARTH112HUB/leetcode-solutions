class Solution {
    public int digitFrequencyScore(int n) {
        int []arr = new int [10];
        while(n>0){
            arr[n%10]++;
            n=n/10;
        }
        int ans=0;
        for(int i=0;i<10;i++){
            ans+=i*arr[i];
        }
        return ans;
    }
}