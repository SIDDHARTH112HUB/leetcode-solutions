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
import java.util.*;

class Solution {
    Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build the map for quick lookup of inorder indices
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd) {
        // Base case
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // Root is always the first element in preorder
        TreeNode root = new TreeNode(preorder[preStart]);

        // Find root index in inorder
        int inRoot = inMap.get(preorder[preStart]);
        int numLeft = inRoot - inStart;

        // Recursively build left and right subtrees
        root.left = buildTree(preorder, preStart + 1, preStart + numLeft,
                              inorder, inStart, inRoot - 1);
        root.right = buildTree(preorder, preStart + numLeft + 1, preEnd,
                               inorder, inRoot + 1, inEnd);

        return root;
    }
}

// // Definition for a binary tree node.
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }
