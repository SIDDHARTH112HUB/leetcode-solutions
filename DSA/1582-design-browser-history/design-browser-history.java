class BrowserHistory {
    // Stack<String> curr,fwd;
    // public BrowserHistory(String homepage) {
    //     curr = new Stack<>();
    //     fwd = new Stack<>();
    //     curr.push(homepage);
    // }
    
    // public void visit(String url) {
    //     curr.push(url);
    //     fwd.clear();         
    // }
    
    // public String back(int steps) {
    //     while(steps>0 && curr.size()>1){
    //         steps--;
    //         fwd.push(curr.pop());
    //     }
    //     if(!curr.isEmpty())
    //     return curr.peek();

    //     return null;
    // }
    
    // public String forward(int steps) {
    //     while(steps>0 && !fwd.isEmpty()){
    //         steps--;
    //         curr.push(fwd.pop());
    //     }
    //     if(!curr.isEmpty())
    //     return curr.peek();

    //     return null;
    // }
    class Node{
        String data;
        Node next;
        Node prev;
        Node(String data){
            this.data=data;
        }
    }
    Node head,tail,cur;
    public BrowserHistory(String homepage) {
        Node temp=new Node(homepage);
        head=temp;
        tail=temp;
        cur=temp;
    }
    
    public void visit(String url) {
        cur.next=null;
        Node temp=new Node(url);
        cur.next=temp;
        temp.prev=cur;
        cur=temp;
        tail=temp;
    }
    
    public String back(int steps) {
        Node temp=cur;
        while(steps>0&&temp!=head){
            temp=temp.prev;
            steps--;
        }
        cur=temp;
        return temp.data;
    }
    public String forward(int steps) {
     Node temp=cur;
     while(steps>0&&temp.next!=null){
        steps--;
        temp=temp.next;
     }   
     cur=temp;
     return temp.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */