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
    public List<Integer> inorderTraversal1(TreeNode root) {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // Current must be null at this point
            curr = stack.pop();
            ans.add(curr.val);

            // We have visited the node and its left subtree. Now, it's right subtree's turn
            curr = curr.right;
        }
        return ans;
    }
}