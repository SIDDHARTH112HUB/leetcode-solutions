import java.util.PriorityQueue;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public long putMarbles(int[] w, int k) {
        // Edge case: if bags equal 1 or the number of elements, difference is 0
        if (k == 1 || k == w.length) {
            return 0;
        }

        // We need k - 1 cuts
        List<Integer> maxk = topKLarge_small(w, k - 1, false);
        List<Integer> mink = topKLarge_small(w, k - 1, true);
        
        long minScore = 0;
        long maxScore = 0;
        
        // Sum up the elements using long to prevent integer overflow
        for (int val : mink) {
            minScore += val;
        }
        for (int val : maxk) {
            maxScore += val;
        }
        
        return maxScore - minScore;
    }
    
    public List<Integer> topKLarge_small(int[] nums, int cuts, boolean minimum) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // If we want the minimums, we use a Max-Heap to eject the largest elements
        if (minimum) {
            pq = new PriorityQueue<>(Collections.reverseOrder());
        }
        
        for (int j = 1; j < nums.length; j++) {
            pq.add(nums[j] + nums[j - 1]);
            
            // Use 'if' instead of 'while' since it only ever grows by 1 per iteration
            if (pq.size() > cuts) {
                pq.poll();
            }
        }
        
        List<Integer> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        
        return list;
    }
}