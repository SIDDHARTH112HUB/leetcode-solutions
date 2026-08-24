class BrowserHistory {
    Stack<String> curr,fwd;
    public BrowserHistory(String homepage) {
        curr = new Stack<>();
        fwd = new Stack<>();
        curr.push(homepage);
    }
    
    public void visit(String url) {
        curr.push(url);
        fwd.clear();         
    }
    
    public String back(int steps) {
        while(steps>0 && curr.size()>1){
            steps--;
            fwd.push(curr.pop());
        }
        if(!curr.isEmpty())
        return curr.peek();

        return null;
    }
    
    public String forward(int steps) {
        while(steps>0 && !fwd.isEmpty()){
            steps--;
            curr.push(fwd.pop());
        }
        if(!curr.isEmpty())
        return curr.peek();

        return null;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */