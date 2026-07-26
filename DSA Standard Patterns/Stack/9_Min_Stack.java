// min stack approach
// here we are using two stacks, one for the actual stack 
// and one for the minimum stack. The minimum stack will always have the minimum element at the top.
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


// optimized approach
// here we are using one stack and a variable to keep track of the minimum element.
// This is an optimized approach with O(1) space complexity and O(1) time complexity for all operations.

class MinStack {
    long minEl= -1;
    Stack<Long> st;
    public MinStack() {
        st = new Stack<>();
        minEl = -1;
    }
    public void push(int value) {ß
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
