class Solution {
    public int findMaxValueOfEquation_bruteforce(int[][] points, int k) {
        int max= Integer.MIN_VALUE;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                if(points[j][0]-points[i][0]<=k)
                max= Math.max(max,points[j][0]-points[i][0]+points[j][1]+points[i][1]);
                else 
                break;
            }
        }
        return max;
    }
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        // Max heap storing (y - x, x)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int[] point : points) {
            int x = point[0], y = point[1];

            // Remove points that are too far
            while (!pq.isEmpty() && x - pq.peek()[1] > k) {
                pq.poll();
            }

            // If heap has valid candidate, compute equation
            if (!pq.isEmpty()) {
                max = Math.max(max, pq.peek()[0] + x + y);
            }

            // Push current point (y - x, x)
            pq.offer(new int[]{y - x, x});
        }

        return max;
    }
}