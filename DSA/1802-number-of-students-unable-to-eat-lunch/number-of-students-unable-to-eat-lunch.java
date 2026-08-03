class Solution {
    public int countStudents(int[] students, int[] sw) {
        int ans=0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> qt = new LinkedList<>();
        int i=0;
        for (int num : students) {
            q.add(num);
        }
        while( true){
            int a1 = q.size();
            while(!q.isEmpty()){
                if(q.peek()==sw[i]){
                    q.poll();
                    i++;
                }
                else{
                    qt.add(q.poll());
                }
            }
            if(qt.size()==a1){
                return a1;
            }
            if(qt.size()==0)
            return 0;
            q =qt;
            qt = new LinkedList<>();
        }
    }
}