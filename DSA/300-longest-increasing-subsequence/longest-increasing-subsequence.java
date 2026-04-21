class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        List<Integer> tails = new ArrayList<>();
        tails.add(nums[0]);
        int ans=1;
        for (int i=1;i<nums.length;i++){
            int num = nums[i]; 
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

