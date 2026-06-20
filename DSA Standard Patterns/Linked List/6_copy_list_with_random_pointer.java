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
    public Node copyRandomList1(Node head) {
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
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Interleave cloned nodes
        Node ptr = head;
        while (ptr != null) {
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        // Step 2: Assign random pointers
        ptr = head;
        while (ptr != null) {
            if (ptr.random != null) {
                ptr.next.random = ptr.random.next;
            }
            ptr = ptr.next.next;
        }

        // Step 3: Separate the lists
        Node dummy = new Node(-1);
        Node copyPtr = dummy;
        ptr = head;
        while (ptr != null) {
            Node cloned = ptr.next;
            copyPtr.next = cloned;
            copyPtr = cloned;

            ptr.next = cloned.next; // restore original list
            ptr = ptr.next;
        }

        return dummy.next;
    }
}
