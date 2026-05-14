class BinaryTree {
    Node root;

    // 1. Pre-order Traversal (Root -> Left -> Right)
    void printPreOrder(Node node) {
        if (node == null) return;

        System.out.print(node.data + " "); // Visit Root
        printPreOrder(node.left);         // Traverse Left
        printPreOrder(node.right);        // Traverse Right
    }

    // 2. In-order Traversal (Left -> Root -> Right)
    void printInOrder(Node node) {
        if (node == null) return;

        printInOrder(node.left);          // Traverse Left
        System.out.print(node.data + " "); // Visit Root
        printInOrder(node.right);         // Traverse Right
    }

    // 3. Post-order Traversal (Left -> Right -> Root)
    void printPostOrder(Node node) {
        if (node == null) return;

        printPostOrder(node.left);         // Traverse Left
        printPostOrder(node.right);        // Traverse Right
        System.out.print(node.data + " ");  // Visit Root
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