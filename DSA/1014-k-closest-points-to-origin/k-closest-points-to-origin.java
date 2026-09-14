class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> dist(b) - dist(a));
        
        for(int[] point : points){
            max.offer(point);

            if(max.size() > k){
                max.poll();
            }
        }

        int[][] ans = new int[k][];

        for(int i = 0; i < k; i++){
            ans[i] = max.poll();
        }

        return ans;

    }
    private int dist(int[] arr){
        int x = arr[0];
        int y = arr[1];
        return x * x + y * y;
    }
}