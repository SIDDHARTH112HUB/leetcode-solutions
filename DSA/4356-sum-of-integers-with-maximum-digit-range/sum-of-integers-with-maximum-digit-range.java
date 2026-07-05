class Solution {
    public int maxDigitRange(int[] nums) {
        int ans =0;
        int currMax = 0;
        for(int i:nums){
            String s = Integer.toString(i);;
            char[] charArray = s.toCharArray();

            // Sort the character array
            Arrays.sort(charArray);
            int m = charArray[charArray.length-1]-charArray[0] ;
            if(m>currMax){
                currMax = m;
                ans=i;
            }
            else if(m==currMax){
                ans+=i;
            }
        }
        return ans;
    }
}