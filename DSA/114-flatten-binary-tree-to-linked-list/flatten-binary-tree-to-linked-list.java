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
    TreeNode prev = null;
    List<TreeNode> pre;
    public void flatten1(TreeNode root) {
        if(root==null)
        return;

        flatten(root.right);
        flatten(root.left);

        root.right=prev;
        root.left = null;
        prev = root;
    }
     public void flatten2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    public void flatten(TreeNode root) {
        pre = new ArrayList<>();
        if(root==null)
        return;
        printPreOrder(root);
        int i;
        for (i=0;i<pre.size()-1;i++){
            TreeNode t = pre.get(i);
            t.left=null;
            t.right = pre.get(i+1);

        }
        pre.get(i).left=null;
        pre.get(i).right=null;
    }
    void printPreOrder(TreeNode node) {
        if (node == null) return;

        pre.add(node); // Visit Root
        printPreOrder(node.left);         // Traverse Left
        printPreOrder(node.right);        // Traverse Right
    }
}