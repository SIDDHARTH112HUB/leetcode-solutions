class Solution {
    class Pair {
        int a;
        int b;
        int sum;
        Pair(int s, int a1, int a2) {
            sum = s;
            a = a1;
            b = a2;
        }
    }
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.sum, a.sum));
        
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            
            // OUTER LOOP PRUNING: If the very first element in this row is already 
            // larger than the max in our full heap, all subsequent rows will also be 
            // too large because nums1 is sorted. We can safely stop completely.
            if (pq.size() == k && nums1[i] + nums2[0] >= pq.peek().sum) {
                break;
            }
            
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                int currentSum = nums1[i] + nums2[j];
                
                if (pq.size() < k) {
                    pq.add(new Pair(currentSum, nums1[i], nums2[j]));
                } else if (currentSum < pq.peek().sum) {
                    pq.poll();
                    pq.add(new Pair(currentSum, nums1[i], nums2[j]));
                } else {
                    // INNER LOOP PRUNING: nums2 is sorted. If this sum is too big, 
                    // the rest of the row will also be too big. Move to the next row.
                    break;
                }
            }
        }
        
        // Use LinkedList instead of ArrayList! 
        List<List<Integer>> ans = new LinkedList<>();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            // Arrays.asList is much cleaner and faster than creating a new ArrayList manually
            ans.add(0, Arrays.asList(p.a, p.b)); 
        }
        
        return ans;
    }
}