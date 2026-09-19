class Solution {
    public int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:arr){
            pq.offer(i);
        }
        int ans=0;
        while(pq.size()>1){
            int a = pq.poll()+pq.poll();
            ans+=a;
            pq.offer(a);
        }
        return ans;
    }
}