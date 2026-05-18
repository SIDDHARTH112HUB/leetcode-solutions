class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        // Search left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides return non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return whichever side is non-null
        return left != null ? left : right;
        
    }
}