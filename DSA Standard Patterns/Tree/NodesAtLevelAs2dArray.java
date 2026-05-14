import java.util.*;

class Node {
    int data;
    Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public List<List<Integer>> levelOrderGroups() {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Number of nodes at the current level
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node tempNode = queue.poll();
                currentLevelList.add(tempNode.data);

                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
            
            // Add the completed level to the final list
            result.add(currentLevelList);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        List<List<Integer>> levels = tree.levelOrderGroups();
        
        System.out.println("Nodes grouped by level:");
        System.out.println(levels); 
        // Output: [[1], [2, 3], [4, 5]]
    }
}