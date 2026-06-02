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

    public TreeNode deleteNode(TreeNode root, int key) {
         if(root == null) {
            return root;
        }

        if(key < root.val) {
            root.left = deleteNode(root.left,key);
        }
        
        else if(root.val < key) {
            root.right = deleteNode(root.right,key);
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

            root.right = deleteNode(root.right, min);
        }
        return root;
    }
}