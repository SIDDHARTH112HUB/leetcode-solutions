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
    public void MyCalendar1() {
        cal = new ArrayList<>();
    }
    
    public boolean book1(int st, int end) {
        for(Pair p:cal){
            if (p.st < end && st < p.end) {
            return false;
        }
        }
        cal.add(new Pair(st,end));
        return true;
    }

    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer prevStart = map.floorKey(startTime);
        if (prevStart != null && map.get(prevStart) > startTime) {
            return false;
        }

        Integer nextStart = map.ceilingKey(startTime);
        if (nextStart != null && nextStart < endTime) {
            return false;
        }

        map.put(startTime, endTime);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */