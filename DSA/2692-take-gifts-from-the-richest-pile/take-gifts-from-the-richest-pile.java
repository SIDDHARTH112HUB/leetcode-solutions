class Solution {
    public long pickGifts(int[] gifts, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:gifts){
            pq.add(i);
        }
        while(k-->0){
            int t = pq.poll();
            t = (int)Math.floor(Math.sqrt(t));
            pq.add(t);
        }
        while (!pq.isEmpty()) {
            ans+=pq.poll();
        }
        return ans;
    }
}