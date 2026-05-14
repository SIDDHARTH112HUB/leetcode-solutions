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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(root,ans);
        return ans;  
    }
    public void inorderTraversal(TreeNode node, List<Integer>t) {
        if (node == null) return;

        inorderTraversal(node.left,t);          
        t.add(node.val);
        inorderTraversal(node.right,t); 
            
    }
}