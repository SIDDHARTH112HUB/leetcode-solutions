class Solution {
    public List<Integer> goodDaysToRobBank(int[] s, int time) {
        int[] leftSide = new int[s.length];
        int[] rightSide = new int[s.length];
        leftSide[0]=0;
        rightSide[s.length-1]=0;
        for(int i=1;i<s.length;i++){
            if(s[i]<=s[i-1]){
                leftSide[i]=leftSide[i-1]+1;
            }
            else{
                leftSide[i]=0;
            }
        }
        for(int i=s.length-2;i>=0;i--){
            if(s[i]<=s[i+1]){
                rightSide[i]=rightSide[i+1]+1;
            }
            else{
                rightSide[i]=0;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=time;i<s.length;i++){
            if(leftSide[i]>=time && rightSide[i]>=time)
            ans.add(i);
        }
        return ans;
    }
}