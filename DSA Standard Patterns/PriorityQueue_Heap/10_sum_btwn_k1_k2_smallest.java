import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int sumBetweenK1K2(int[] arr, int k1, int k2) {
        int start = Math.min(k1, k2);
        int end = Math.max(k1, k2);

        // Max-Heap to keep only the 'end' smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > end) {
                maxHeap.poll();
            }
        }

        // At this point, the heap contains exactly the 'end' smallest elements.
        // The very top of the heap is the k2-th smallest element. We discard it.
        maxHeap.poll(); 

        long ans = 0;
        int elementsToSum = end - start - 1;

        // Pop and sum the elements strictly between k2 and k1
        for (int i = 0; i < elementsToSum; i++) {
            ans += maxHeap.poll();
        }

        return (int) ans;
    }
}