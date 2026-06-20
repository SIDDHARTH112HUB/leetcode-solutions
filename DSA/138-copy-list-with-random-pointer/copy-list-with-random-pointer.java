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
        if (head == null) return null;

        Map<Node, Node> mp = new HashMap<>();
        Node dummy = new Node(-1);
        Node curr = dummy;

        while (head != null) {
            Node newNode = mp.getOrDefault(head, new Node(head.val));
            mp.put(head, newNode);

            curr.next = newNode;
            curr = curr.next;

            if (head.random != null) {
                Node randomNode = mp.getOrDefault(head.random, new Node(head.random.val));
                mp.put(head.random, randomNode);
                newNode.random = randomNode;
            }

            head = head.next;
        }

        return dummy.next;
    }
}