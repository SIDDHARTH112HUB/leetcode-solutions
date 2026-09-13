class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i:nums){
            mp.merge(i,1,Integer::sum);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(Map.Entry<Integer,Integer> en:mp.entrySet()){
            pq.add(new int[]{en.getValue(),en.getKey()});
            while(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            int b[] = pq.poll();
            ans[i++] = b[1];
        }
        return ans;
    }
}