class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int c:nums){
            mp.merge(c,1,Integer::sum);
        }
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> {
                        int compareFirst = Integer.compare(a[0], b[0]);
                        if (compareFirst != 0) {
                            return compareFirst; // Returns negative if a[0] < b[0] (Ascending)
                        }
                        return Integer.compare(b[1], a[1]); // Swapped b and a for Descending
                    });
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            pq.add(new int[]{entry.getValue(),entry.getKey()});
        }
        int i=0;
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int j=0;
            while(j<p[0]){
                nums[i] = p[1];
                j++;
                i++;
            }
        }
        return nums;
    }
}