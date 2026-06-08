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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
        return 0;

        int left = pathSum(root.left,targetSum);
        int right = pathSum(root.right, targetSum);

        return left+right+ pathSum2(root,targetSum);
    }
    public int pathSum2(TreeNode root, long s){
        if(root==null)
        return 0;

        int count=0;
        if(root.val==s)
        count=1;

        count+=pathSum2(root.left, s-root.val);
        count+=pathSum2(root.right, s-root.val);

        return count;
        
    }
}