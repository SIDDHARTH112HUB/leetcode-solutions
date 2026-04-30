class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j=0,z=0,ans=0;
        while(j<nums.length){
            if(nums[j]==0){
                z++;
            }
            while(z>1 ){
                if(nums[i]==0)
                {
                    z--;
                }
                i++;
            }
            // System.out.print(" i:"+i);
            // System.out.print(" j: "+j);
            // System.out.print(" z: "+z);
            // System.out.print( " ans: "+ans);
            // System.out.println("");

            ans = Math.max(j-i,ans);
            j++;
        }
        return ans;
    }
}