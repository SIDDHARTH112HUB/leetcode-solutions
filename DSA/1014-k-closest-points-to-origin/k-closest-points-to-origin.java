class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(b[0],a[0]));
        int i=0;
        for(int []a:points){
            long l = (long)a[0]*a[0] +(long)a[1]*a[1];
            System.out.print(l);
            System.out.print(" ");
            System.out.println(i);
            pq.add(new long[]{l,i});
            i++;
            while(pq.size()>k){
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        i=0;
        while(!pq.isEmpty()){
            long b[] = pq.poll();
            int t =(int)b[1];
            System.out.println(t);
            ans[i][0] = points[t][0];
            ans[i][1] = points[t][1];
            i++;
        }
        return ans;
    }
}