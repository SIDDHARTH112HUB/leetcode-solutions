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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        // Base case: empty tree
        if (root == null) return null;

        // If current node value < L, discard left subtree
        // and trim only the right subtree
        if (root.val < L) return trimBST(root.right, L, R);

        // If current node value > R, discard right subtree
        // and trim only the left subtree
        if (root.val > R) return trimBST(root.left, L, R);

        // Otherwise, current node is within [L, R]
        // Recursively trim both sides
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}

/*
================ DEMO on input =================
Tree:        3
            / \
           0   4
            \
             2
            /
           1

Range: L = 1, R = 3

Step-by-step:

1. Start at root = 3
   - 3 is within [1,3], keep it.
   - Trim left and right.

2. Left child = 0
   - 0 < L (1), so discard left subtree.
   - Move to right child (2).

3. Node = 2
   - 2 is within [1,3], keep it.
   - Trim left and right.

4. Left child = 1
   - 1 is within [1,3], keep it.
   - Both children are null → done.

5. Right child of 2 = null → done.

6. Right child of root = 4
   - 4 > R (3), discard right subtree.
   - Move to left child (null) → done.

================ FINAL TRIMMED TREE =================
        3
       /
      2
     /
    1

=====================================================
*/
