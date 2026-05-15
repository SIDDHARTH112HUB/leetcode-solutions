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
    public boolean isBalanced1(TreeNode root) {
        if(root==null)
        return true;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return isBalanced(root.left)&&isBalanced(root.right)&& Math.abs(left-right)<=1;
    }
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}