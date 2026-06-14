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
    TreeNode first, sec,third;
    TreeNode prev= null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(first==null)
        return;
        int a = first.val;
        first.val = third.val;
        third.val = a;
    }
    public void inorder(TreeNode root){
        if(root==null)
        return;

        inorder(root.left);
        //System.out.print(root.val);
        //System.out.print(" ");
        if(prev!=null){
            //System.out.print(prev.val);
            if(prev.val>root.val){
                assign(root);
            }
            prev = root;
        }
        else{
            prev = root;
        }
        //System.out.println();
        inorder(root.right);
    }
    public void assign(TreeNode root){
        if(first==null){
            first = prev;
            sec = root;
            third = root;
        }
        else{
            third = root;
        }
    }
}