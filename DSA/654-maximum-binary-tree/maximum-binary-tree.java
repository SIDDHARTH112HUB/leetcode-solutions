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
 import java.util.Arrays;
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] num) {
        return constructMaximumBinaryTree(num,0,num.length-1);
    }
    public TreeNode constructMaximumBinaryTree(int[] num,int left, int right) {
        if(left>right)
        return null;

        int maxi=left;
        int max=num[left];
        for(int i=left;i<=right;i++){
            if(max<num[i]){
                max= num[i];
                maxi=i;
            }
        }
        TreeNode root = new TreeNode(num[maxi]);
        root.left = constructMaximumBinaryTree(num,left,maxi-1);
        root.right = constructMaximumBinaryTree(num,maxi+1,right);

        return root;
    }
}