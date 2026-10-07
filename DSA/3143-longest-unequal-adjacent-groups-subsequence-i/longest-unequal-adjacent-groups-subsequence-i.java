class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int zero=0;
        for(int i:groups){
            if(i==0 && zero%2==0){
                zero++;
            }
            else if(i==1 && zero%2==1){
                zero++;
            }
        }
        int one =0;
        for(int i:groups){
            if(i==1 && one%2==0){
                one++;
            }
            else if(i==0 && one%2==1){
                one++;
            }
        }
        boolean startZero = zero>one;
        List<String> ans = new ArrayList<>();
        for(int i=0;i<groups.length;i++){
            if(startZero==true && groups[i]==0){
                ans.add(words[i]);
                startZero = false;
            }
            else if(startZero==false && groups[i]==1){
                ans.add(words[i]);
                startZero = true;
            }
        }
        return ans;
    }
}