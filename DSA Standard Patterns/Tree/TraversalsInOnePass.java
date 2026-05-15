import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Pair {
    TreeNode node;
    int state;
    Pair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class TraversalsInOnePass {
    public static void main(String[] args) {
        // Example tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair top = stack.peek();

            if (top.state == 1) {
                // Preorder
                preorder.add(top.node.val);
                top.state++;
                if (top.node.left != null) {
                    stack.push(new Pair(top.node.left, 1));
                }
            } else if (top.state == 2) {
                // Inorder
                inorder.add(top.node.val);
                top.state++;
                if (top.node.right != null) {
                    stack.push(new Pair(top.node.right, 1));
                }
            } else {
                // Postorder
                postorder.add(top.node.val);
                stack.pop();
            }
        }

        System.out.println("Preorder: " + preorder);
        System.out.println("Inorder: " + inorder);
        System.out.println("Postorder: " + postorder);
    }
}
