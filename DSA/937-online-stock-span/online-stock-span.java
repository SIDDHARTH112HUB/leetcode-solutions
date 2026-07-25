class Pair{
    int value;
    int index;
    public Pair(int v, int i){
        value =v;
        index = i;
    }
}
class StockSpanner {

    int i=0;
    ArrayList<Integer> nums;
    
    Stack<Pair> st;
    public StockSpanner() {
        st = new Stack<>();
        nums = new ArrayList<>();
        i=0;
    }
    
    public int next(int price) {
        if(i==0){
            st.push(new Pair(price,i));
            i++;
            return 1;
        }
        while (!st.isEmpty() && price >= st.peek().value) {
            st.pop();
        }
        int ans=i+1;
        if(!st.isEmpty()){
            Pair p = st.peek();
            ans = i-p.index;
        }
        st.push(new Pair(price,i));
        i++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */