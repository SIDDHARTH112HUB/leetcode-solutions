class MinStack {
    long minEl= -1;
    Stack<Long> st;
    public MinStack() {
        st = new Stack<>();
        minEl = -1;
    }
    
    public void push(int value) {
        if(st.size()==0){
            st.push((long)value);
            minEl = value;
        }
        else if(value <minEl){
            st.push(2L*value - minEl);
            minEl = value;
        }
        else
        st.push((long)value);
    }
    
    public void pop() {
        long v = st.pop();
        if(v<minEl){
            minEl = 2*minEl- v;
        }
    }
    
    public int top() {
        long t = st.peek();
        if(t>=minEl)
        return (int)t;
        else
        return (int)minEl;
    }
    
    public int getMin() {
        return (int)minEl;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */