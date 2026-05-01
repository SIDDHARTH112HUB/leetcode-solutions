class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count=0;
        List<Integer> q = new ArrayList<>();
        int i=0,j=0,ans=0;
        while(j<nums.length){
            if(nums[j]%2==1)
            {   
                q.add(j);
                count++;
            }
            if(count>k){
                i=q.get(q.size()-count)+1;
                count--;
            }
            if(count==k){
                ans+=q.get(q.size()-count)-i+1;
            }
            j++;

        }
        return ans;
    }
}