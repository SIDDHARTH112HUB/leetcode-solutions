/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();
    private boolean reverse;

    // reverse = false → inorder (smallest to largest)
    // reverse = true  → reverse inorder (largest to smallest)
    public BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        TreeNode node = st.pop();
        if (!reverse) {
            pushAll(node.right);
        } else {
            pushAll(node.left);
        }
        return node.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = reverse ? node.right : node.left;
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        BSTIterator l = new BSTIterator(root, false);  // smallest
        BSTIterator r = new BSTIterator(root, true);   // largest

        int i = l.next();
        int j = r.next();

        while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) {
                if (l.hasNext()) i = l.next();
                else return false;
            } else {
                if (r.hasNext()) j = r.next();
                else return false;
            }
        }
        return false;
    }
}