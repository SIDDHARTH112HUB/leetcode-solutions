class Solution {
    public int longestSubsequence(int[] nums) {
        int ans=0;
        for(int i=0;i<30;i++){
            int bit = 1 << i;
            List<Integer> l = new ArrayList<>();
            for (int a : nums) {
                if ((a & bit) != 0) 
                {
                    l.add(a);
                }    
            }
            ans = Math.max(ans,lengthOfLIS(l));       
        }
        return ans;
    }
    public int lengthOfLIS(List<Integer>  nums) {
        if (nums == null || nums.size() == 0) return 0;
        
        List<Integer> tails = new ArrayList<>();
        tails.add(nums.get(0));
        int ans=1;
        for (int i=1;i<nums.size();i++){
            int num = nums.get(i); 
            if(num>tails.get(tails.size()-1))
            {    
                tails.add(num);
                ans++;
            }
            
            else{
                int index = findLowerBound(tails,tails.size(), num);
                tails.set(index, num);
            }
        }
        
        return ans;
    }
    private int findLowerBound(List<Integer> arr, int high, int target) {
        int low = 0;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr.get(mid) < target) { 
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}