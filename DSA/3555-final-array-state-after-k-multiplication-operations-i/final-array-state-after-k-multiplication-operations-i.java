class Pair {
    int num;
    int i;
    public Pair(int k, int n) {
        num = k;
        i = n;
    }
}
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            Comparator.comparingInt((Pair p) -> p.num)
                      .thenComparingInt(p -> p.i)
        );
        for(int i=0;i<nums.length;i++){
            pq.add(new Pair(nums[i],i));
        }
        while(k-->0){
            Pair p = pq.poll();
            p.num = p.num*multiplier;
            pq.add(p);
        }
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            nums[p.i] = p.num;
        }
        return nums;
    }
}