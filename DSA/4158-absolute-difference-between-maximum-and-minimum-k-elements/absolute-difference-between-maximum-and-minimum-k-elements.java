class Solution {
    public int absDifference(int[] nums, int k) {
        return kLargestSum(nums,k) - kSmallestSum(nums,k);
    }
    public int kSmallestSum(int[] arr, int k) {
        // Code here
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for( int i: arr){
            pq.add(i);
            while(pq.size()>k){
                pq.poll();
            }
        }
        int sum=0;
        while(pq.size()>0){
                sum+=pq.poll();
            }

        return sum;
    }
    public int kLargestSum(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for( int i: nums){
            pq.add(i);
            while(pq.size()>k){
                pq.poll();
            }
        }
        int sum=0;
        while(pq.size()>0){
                sum+=pq.poll();
            }

        return sum;
    }
}