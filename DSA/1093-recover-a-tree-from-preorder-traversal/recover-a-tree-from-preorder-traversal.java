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
    public TreeNode recoverFromPreorder(String s) {
        int i = 0;
        Stack<TreeNode> stack = new Stack<>();

        while (i < s.length()) {
            // count depth
            int depth = 0;
            while (i < s.length() && s.charAt(i) == '-') {
                depth++;
                i++;
            }
            // parse number
            int start = i;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                i++;
            }
            int val = Integer.parseInt(s.substring(start, i));

            TreeNode node = new TreeNode(val);

            // adjust stack to correct depth
            while (stack.size() > depth) {
                stack.pop();
            }

            // attach to parent
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) parent.left = node;
                else parent.right = node;
            }

            stack.push(node);
        }

        return stack.get(0); // root
    }
}

