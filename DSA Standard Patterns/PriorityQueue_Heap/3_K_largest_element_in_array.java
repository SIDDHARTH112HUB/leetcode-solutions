import java.util.*; 

class Solution {
    public ArrayList<Integer> kLargest(int[] nums, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for( int i: nums){
            pq.add(i);
            while(pq.size()>k){
                pq.poll();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        // Destructively poll elements to maintain priority sorting
        while (!pq.isEmpty()) {
            list.add(0,pq.poll());
        }
        return list;
    }
}
