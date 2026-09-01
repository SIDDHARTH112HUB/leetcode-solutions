import java.util.*;


class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for( int i: arr){
            pq.add(i);
            while(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}