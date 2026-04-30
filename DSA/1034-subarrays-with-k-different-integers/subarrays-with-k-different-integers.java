class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        int ans = at_most_K(nums,k)-at_most_K(nums,k-1);
        
        
        return ans;
        
    }
    public int at_most_K(int[] nums, int k) {
        
        // write code here
        int i=0,j=0;
        int ans = 0;
        TreeMap<Integer,Integer> temp = new TreeMap<>();
        while(j<nums.length){
            temp.merge(nums[j],1,Integer::sum); 
            
            while(temp.size()>k){
                temp.computeIfPresent(nums[i],(ki,v)->(v>1)?v-1:null);
                i++;
            }
            
            ans+=j-i+1;
            j++;
        }
        
        
        return ans;
        
    }
    
}