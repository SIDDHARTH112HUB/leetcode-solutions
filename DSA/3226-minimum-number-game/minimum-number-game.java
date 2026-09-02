class Solution {
    public int[] numberGame(int[] nums) {
        int [] ans = new int[nums.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int j=0;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        
        while (!pq.isEmpty()) {
            ans[j+1]=pq.poll();
            ans[j] = pq.poll();
            j=j+2;
        }
        return ans;
    }
}