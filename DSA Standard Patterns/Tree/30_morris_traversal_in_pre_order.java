class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class MorrisTraversal {
    // Inorder Traversal
    public void morrisInorder(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr; // create thread
                    curr = curr.left;
                } else {
                    prev.right = null; // remove thread
                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            }
        }
    }

    // Preorder Traversal
    public void morrisPreorder(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    System.out.print(curr.val + " "); // print before going left
                    prev.right = curr; // create thread
                    curr = curr.left;
                } else {
                    prev.right = null; // remove thread
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        MorrisTraversal mt = new MorrisTraversal();
        System.out.println("Morris Inorder:");
        mt.morrisInorder(root);
        System.out.println("\nMorris Preorder:");
        mt.morrisPreorder(root);
    }
}
