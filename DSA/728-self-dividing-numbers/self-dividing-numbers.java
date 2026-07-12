class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();

        for(int i=left;i<=right;i++){
            if(isSelfDividing(i)){
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean  isSelfDividing(int a){
        String s =Integer.toString(a);
        for(char c : s.toCharArray()){
            if(c=='0')
            return false;

            int b = c-'0';
            if(a%b!=0){
                return false;
            }
        }
        return true;
    }
}