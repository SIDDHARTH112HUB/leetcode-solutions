class Pair{
    int key;
    int num;
    public Pair(int k, int n){
        key= k;
        num = n;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.key)
              .thenComparingInt(p -> p.num)
              .reversed());
        for (int i:arr) {
            pq.add(new Pair(Math.abs(i-x),i));
            while(pq.size()>k){
                pq.poll();
                //System.out.println(pq.poll().num);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            ans.add(p.num);
        }
        Collections.sort(ans);
        return ans;
    }
}