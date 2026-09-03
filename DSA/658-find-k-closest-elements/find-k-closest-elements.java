class Pair {
    int key;
    int num;
    public Pair(int k, int n) {
        key = k;
        num = n;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Max heap: farthest distances at the top. Ties broken by larger number at the top.
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            Comparator.comparingInt((Pair p) -> p.key)
                      .thenComparingInt(p -> p.num)
                      .reversed()
        );
        
        for (int i : arr) {
            pq.add(new Pair(Math.abs(i - x), i));
            // Just need 'if' since we add one at a time
            if (pq.size() > k) { 
                pq.poll();
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll().num);
        }
        
        // Problem requires the result to be sorted in ascending order
        Collections.sort(ans);
        return ans;
    }
}