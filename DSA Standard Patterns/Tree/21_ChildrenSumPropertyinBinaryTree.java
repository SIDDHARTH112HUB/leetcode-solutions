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

class Solution {
    public static void changeTree(TreeNode root) {
        if (root == null) return;

        // Step 1: Calculate sum of children
        int child = 0;
        if (root.left != null) {
            child += root.left.val;
        }
        if (root.right != null) {
            child += root.right.val;
        }

        // Step 2: Adjust current node or children
        if (child >= root.val) {
            root.val = child;
        } else {
            if (root.left != null) {
                root.left.val = root.val;
            } else if (root.right != null) {
                root.right.val = root.val;
            }
        }

        // Step 3: Recurse on left and right subtrees
        changeTree(root.left);
        changeTree(root.right);

        // Step 4: Update current node after recursion
        int tot = 0;
        if (root.left != null) tot += root.left.val;
        if (root.right != null) tot += root.right.val;

        if (root.left != null || root.right != null) {
            root.val = tot;
        }
    }
}
