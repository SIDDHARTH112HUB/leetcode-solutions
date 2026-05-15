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
    boolean isBalanced =true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }
    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        if(Math.abs(left-right)>1)
        isBalanced = false;
        // Return height of this subtree
        return 1 + Math.max(left, right);
    }
}