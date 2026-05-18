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
    int ans;
    int t=Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        t=k;
        getInOrder(root);
        return ans;
    }
    void getInOrder(TreeNode node) {
        if (node == null) return;
        if (t< 0) return;
        
        getInOrder(node.left);
        t--;         // Traverse Left
        if(t==0)
        {ans = node.val;
            return;
        }          // Visit Root
        getInOrder(node.right);        // Traverse Right
    }
}