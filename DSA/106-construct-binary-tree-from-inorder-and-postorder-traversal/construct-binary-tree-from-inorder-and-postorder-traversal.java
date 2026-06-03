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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Build the map for quick lookup of inorder indices
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int postStart, int postEnd,
                               int[] inorder, int inStart, int inEnd) {
        // Base case
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        // Root is always the last element in postorder
        TreeNode root = new TreeNode(postorder[postEnd]);

        // Find root index in inorder
        int inRoot = inMap.get(postorder[postEnd]);
        int numLeft = inRoot - inStart;

        // Recursively build left and right subtrees
        root.left = buildTree(postorder, postStart, postStart + numLeft - 1,
                              inorder, inStart, inRoot - 1);
        root.right = buildTree(postorder, postStart + numLeft, postEnd - 1,
                               inorder, inRoot + 1, inEnd);

        return root;
    }
}

// Definition for a binary tree node.
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int x) { val = x; }
//     TreeNode(int x, TreeNode left, TreeNode right) {
//         this.val = x;
//         this.left = left;
//         this.right = right;
//     }
// }
