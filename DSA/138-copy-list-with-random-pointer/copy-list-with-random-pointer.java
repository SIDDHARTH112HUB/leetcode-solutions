/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
     Node temp=head;
     while(temp!=null){
        map.put(temp,new Node(temp.val));
        temp=temp.next;
     }
     for(Map.Entry<Node,Node> entry:map.entrySet()){
        Node cur=entry.getValue();
        cur.next=map.get(entry.getKey().next);
        cur.random=map.get(entry.getKey().random);
     }
     return map.get(head);
    }
}