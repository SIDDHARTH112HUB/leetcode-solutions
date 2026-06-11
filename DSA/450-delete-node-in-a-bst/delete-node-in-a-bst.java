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
    public int minValue(TreeNode root) {
        while(root.left != null) {
            root=root.left;
        }
        return root.val;
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
         if(root == null) {
            return root;
        }

        if(key < root.val) {
            root.left = deleteNode1(root.left,key);
        }
        
        else if(root.val < key) {
            root.right = deleteNode1(root.right,key);
        }
        else {
            if(root.left == null) {
                return root.right;
            }

            if(root.right == null) {
                return root.left;
            }

            int min = minValue(root.right);
            root.val = min;

            root.right = deleteNode1(root.right, min);
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }
        if(root.val == key){
            return resetNode(root);
        }
        TreeNode dum = root;
        while(dum!=null){
            if(dum.val>key){
                if(dum.left!=null && dum.left.val==key){
                    dum.left = resetNode(dum.left);
                    break;
                }
                dum=dum.left;
            }
            else{
                if(dum.right!=null && dum.right.val==key){
                    dum.right = resetNode(dum.right);
                    break;
                }
                dum=dum.right;
            }
        }


        return root;
    }
    public TreeNode resetNode(TreeNode root){
        if(root.left==null)
        return root.right;

        if(root.right==null)
        return root.left;

        TreeNode right = minNode(root.right);

        right.left = root.left;

        return root.right;
    }
    public TreeNode minNode(TreeNode root) {
        while(root.left != null) {
            root=root.left;
        }
        return root;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null && root.val!=val){
            root = root.val<val?root.right:root.left;
        }
        return root;
    }
}