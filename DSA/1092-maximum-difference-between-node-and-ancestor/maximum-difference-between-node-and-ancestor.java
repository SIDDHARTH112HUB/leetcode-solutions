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
    public int maxAncestorDiff(TreeNode root) {
        return maxDiff(root,root.val,root.val);
    }
    int maxDiff(TreeNode root,int min, int max){
        if(root==null){
            return Math.abs(min-max);
        }
        min = Math.min(min,root.val);
        max = Math.max(max,root.val);

        int cdiff = Math.abs(min-max);

        int left = maxDiff(root.left,min,max);
        int right = maxDiff(root.right,min,max);

        return Math.max(cdiff, Math.max(left,right));

    }
}