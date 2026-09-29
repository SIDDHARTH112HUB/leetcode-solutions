class Solution {
    public int minDeletion(String s, int k) {
        int [] a = new int [26];
        for(char c:s.toCharArray()){
            a[c-'a']++;
        }
        Arrays.sort(a);
        int ans=0;
        for(int i=0;i<26-k;i++){
            ans+=a[i];
        }
        return ans;
    }
}