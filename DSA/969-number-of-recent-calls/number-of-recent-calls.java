class RecentCounter {
    Queue<Integer> q;

    public RecentCounter() {
        q= new LinkedList<>();
    }
    
    public int ping(int t) {
        q.add(t);
        //System.out.println(q.peek()+" q , t "+t);
        while(q.peek()<t-3000){
            //System.out.println(q.peek()+" q , t "+t);
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */