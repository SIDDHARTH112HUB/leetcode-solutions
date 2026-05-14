import java.util.*;

class BinaryTree {
    Node root;

    // 1. Pre-order Traversal (Root -> Left -> Right)
    public void iterativePreOrder(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");

            // Push right first so left is processed first
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    // 2. In-order Traversal (Left -> Root -> Right)
    public void iterativeInOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Current must be null at this point
            curr = stack.pop();
            System.out.print(curr.data + " ");

            // We have visited the node and its left subtree. Now, it's right subtree's turn
            curr = curr.right;
        }
    }

    public List<Integer> postorderTraversal(Node root) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        st1.push(root);
        while (!st1.isEmpty()) {
            Node t = st1.pop();
            st2.push(t);
            if(t.left!=null) st1.push(t.left);
            if(t.right!=null) st1.push(t.right);
        }
        while(!st2.isEmpty()){
            ans.add(st2.peek().val);
            st2.pop();
        }
        return ans;
    }

    // 3. Post-order Traversal (Left -> Right -> Root)
    public void iterativePostOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        Node lastVisited = null;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node peekNode = stack.peek();
                // If right child exists and traversing node from left child, move right
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    curr = peekNode.right;
                } else {
                    System.out.print(peekNode.data + " ");
                    lastVisited = stack.pop();
                }
            }
        }
    }
    void printLevelOrder() {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // poll() removes the present head
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            // Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            // Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}