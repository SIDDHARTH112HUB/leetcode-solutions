class Solution {
    class Node{
        int val;
        Node next;
        Node prev;
        Node(int data){
            this.val=data;
        }
    }
    public int findTheWinner(int n, int k) {
        Node head = prepare(n);
        while(n>1){
            int t = k;
            Node tmp = head;
            while(t-->1){
                tmp = tmp.next;
            }
            System.out.println(tmp.val);
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
            head = tmp.next;
            n--;
        }
        return head.val;
    }
    public Node prepare(int n){
        Node head = new Node(1);
        int i=2;
        Node temp =head;
        while(i<=n){
            Node t = new Node(i);
            i++;
            temp.next = t;
            t.prev = temp;
            temp = t;
        }
        temp.next = head;
        head.prev = temp;
        return head;
    }
}