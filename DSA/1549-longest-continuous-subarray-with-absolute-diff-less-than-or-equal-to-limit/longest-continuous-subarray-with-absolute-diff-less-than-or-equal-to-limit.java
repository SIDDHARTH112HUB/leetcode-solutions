class Solution {
    public int longestSubarray1(int[] nums, int limit) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int i=0,j=0,ans=0;
        while(j<nums.length){
            int c = nums[j];
            map.merge(c,1,Integer::sum);
            while(map.lastKey()-map.firstKey()>limit){
                int c1= nums[i];
                map.computeIfPresent(c1,(k,v)->(v>1)?v-1:null);
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
    public int longestSubarray2(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0, j = 0, ans = 0;

        while (j < nums.length) {
            // 1. Add the NEW element at index j to the map
            int incoming = nums[j];
            map.put(incoming, map.getOrDefault(incoming, 0) + 1);

            // 2. If the limit is exceeded, shrink the window from the left (i)
            while (map.lastKey() - map.firstKey() > limit) {
                int outgoing = nums[i];
                int count = map.get(outgoing);
                if (count == 1) {
                    map.remove(outgoing);
                } else {
                    map.put(outgoing, count - 1);
                }
                i++; // Shrink window
            }

            // 3. Update the maximum length found so far
            ans = Math.max(ans, j - i + 1);
            j++; // Expand window
        }
        return ans;
    }
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        int left = 0, maxLength = 0;

        for (int right = 0; right < nums.length; ++right) {
            maxHeap.offer(new int[] { nums[right], right });
            minHeap.offer(new int[] { nums[right], right });

            // Check if the absolute difference between the maximum and minimum values in the current window exceeds the limit
            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                // Move the left pointer to the right until the condition is satisfied.
                // This ensures we remove the element causing the violation
                left = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;

                // Remove elements from the heaps that are outside the current window
                while (maxHeap.peek()[1] < left) {
                    maxHeap.poll();
                }
                while (minHeap.peek()[1] < left) {
                    minHeap.poll();
                }
            }

            // Update maxLength with the length of the current valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    public int longestSubarray3(int[] nums, int limit) {
        // Deques to store indices of elements
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        int i = 0, j = 0, ans = 0;

        while (j < nums.length) {
            // Maintain maxDeque: remove elements smaller than current from the back
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[j]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(j);

            // Maintain minDeque: remove elements larger than current from the back
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[j]) {
                minDeque.pollLast();
            }
            minDeque.addLast(j);

            // If the current window violates the limit
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                // If the element at i is the current max or min, pop it from the front
                if (maxDeque.peekFirst() == i) maxDeque.pollFirst();
                if (minDeque.peekFirst() == i) minDeque.pollFirst();
                i++; // Shrink the window
            }

            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}