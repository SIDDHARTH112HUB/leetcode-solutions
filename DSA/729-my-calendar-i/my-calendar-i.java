class MyCalendar {
    class Pair{
        int st;
        int end;
        public Pair(int a,int b){
            st=a;
            end =b;
        }
    }
    List<Pair> cal;
    public MyCalendar() {
        cal = new ArrayList<>();
    }
    
    public boolean book(int st, int end) {
        for(Pair p:cal){
            if (p.st < end && st < p.end) {
            return false;
        }
        }
        cal.add(new Pair(st,end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */