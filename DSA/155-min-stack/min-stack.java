class MinStack {
    Stack<Integer> minSt;
    Stack<Integer> st;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if(minSt.empty()||minSt.peek()>=value){
            minSt.push(value);
        }
    }
    
    public void pop() {
        int v = st.pop();
        if(minSt.peek()==v){
            minSt.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
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