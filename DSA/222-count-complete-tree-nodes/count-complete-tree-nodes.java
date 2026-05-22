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
    int n=0;
    public int countNodes1(TreeNode root) {
        if(root==null)
        return n;
        countHelper(root);
        return n;
    }
    void countHelper(TreeNode root) {
        if(root==null)
        return ;
        n++;
        countHelper(root.left);
        countHelper(root.right);
    }
    public int countNodes(TreeNode root) {
        if(root==null)
        return 0;

        int l = leftHeight(root);
        int r = rightHeight(root);

        if(l==r) return ((2<<l) -1);

        return countNodes(root.left)+countNodes(root.right)+1;
    }

    int leftHeight(TreeNode root) {
        int n=0;
        while(root.left!=null){
            root=root.left;
            n++;
        }

        return n;
    }
    int rightHeight(TreeNode root) {
        int n=0;
        while(root.right!=null){
            root=root.right;
            n++;
        }

        return n;
    }
}