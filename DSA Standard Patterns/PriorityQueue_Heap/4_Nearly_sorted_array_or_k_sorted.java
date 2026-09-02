import java.util.*;
class Solution {
    public void nearlySorted(int[] nums, int k) {
        // code here
        int i=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for( int n: nums){
            pq.add(n);
            while(pq.size()>k){
                nums[i]=pq.poll();
                i++;
            }
        }

        // Destructively poll elements to maintain priority sorting
        while (!pq.isEmpty()) {
            nums[i]=pq.poll();
            i++;
        }
    }
}
