class Solution {
    public int minSetSize(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i:arr){
            mp.merge(i, 1, Integer::sum);
        }
        int total = arr.length;
        for(Map.Entry<Integer,Integer> en:mp.entrySet()){
            // System.out.print(en.getValue());
            // System.out.print(a[1]);
            pq.add(new int[]{en.getValue(),en.getKey()});
        }
        int size=0;
        int ans =0;
        while(size<total/2){

            int a[]=pq.poll();
            // System.out.print(a[0]);
            // System.out.println(a[1]);
            size+= a[0];
            ans++;
        }
        return ans;
    }
}