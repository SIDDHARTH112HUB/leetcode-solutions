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
    // Helper class to store a node along with its "index" in a virtual complete binary tree
    class Pair {
        long num;       // position/index of the node
        TreeNode node;  // actual tree node
        public Pair(TreeNode root, long n) {
            node = root;
            num = n;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        // Use a deque for BFS traversal
        Deque<Pair> q = new ArrayDeque<>();
        long ans = 0;

        // Edge case: if tree is empty
        if (root == null) return (int) ans;

        // Start with root at index 0
        q.add(new Pair(root, 0));

        // Level order traversal
        while (!q.isEmpty()) {
            int n = q.size();

            // Get the index of the first and last node in this level
            long st = q.peekFirst().num;
            long end = q.peekLast().num;

            // Width of current level = end - start + 1
            ans = Math.max(ans, end - st + 1);

            // Process all nodes in this level
            while (n-- > 0) {
                Pair t = q.poll();

                // Assign indices to children based on complete binary tree rules:
                // left child → 2 * index + 1
                // right child → 2 * index + 2
                if (t.node.left != null) {
                    q.add(new Pair(t.node.left, 2 * t.num + 1));
                }
                if (t.node.right != null) {
                    q.add(new Pair(t.node.right, 2 * t.num + 2));
                }
            }
        }

        // Return maximum width found
        return (int) ans;
    }
}
