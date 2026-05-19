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
    int ans=0;
    public int goodNodes(TreeNode root) {
        preOrder(root,Integer.MIN_VALUE);
        return ans;
    }
    void preOrder(TreeNode node,int max) {
        if (node == null) return;
        if(node.val>=max)
        {
            ans++;
            max= node.val;
        }
        
        preOrder(node.left,max);         // Traverse Left
        preOrder(node.right,max);        // Traverse Right
    }
}