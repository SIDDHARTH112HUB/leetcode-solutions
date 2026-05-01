class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        int i=0,j=0,ans=0;
        while(j<nums.length){
            if(nums[j]%2==1)
            q.add(j);
            while(q.size()>k){
                i=q.poll()+1;
                
            }
            if(q.size()==k){
                ans+=q.peek()-i+1;
            }
            j++;

        }
        return ans;
    }
}