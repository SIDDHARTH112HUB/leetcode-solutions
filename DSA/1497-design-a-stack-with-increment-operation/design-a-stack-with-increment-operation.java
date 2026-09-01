class CustomStack {
    int [] st;
    int n=-1;
    int i=-1;
    public CustomStack(int maxSize) {
        st = new int[maxSize];
        n = maxSize;
        i=0;
    }
    
    public void push(int x) {
        if(i<n){
            st[i]=x;
            i++;
        }
    }
    
    public int pop() {
        if(i>0){
            int ans= st[i-1];
            i--;
            return ans;
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        for(int j=0;j<k&&j<i;j++){
            st[j]=st[j]+val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */