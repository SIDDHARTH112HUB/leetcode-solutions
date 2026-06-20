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
    List<Integer> num;
    public TreeNode insertIntoMaxTree1(TreeNode root, int val) {
        num = new ArrayList<>();
        printInOrder(root);
        num.add(val);
        return constructMaximumBinaryTree(0,num.size()-1);
    }
    void printInOrder(TreeNode node) {
        if (node == null) return;

        printInOrder(node.left);          // Traverse Left
        num.add(node.val); // Visit Root
        printInOrder(node.right);         // Traverse Right
    }
    public TreeNode constructMaximumBinaryTree(int left, int right) {
        if(left>right)
        return null;

        int maxi=left;
        int max=num.get(left);
        for(int i=left;i<=right;i++){
            if(max<num.get(i)){
                max= num.get(i);
                maxi=i;
            }
        }
        TreeNode root = new TreeNode(num.get(maxi));
        root.left = constructMaximumBinaryTree(left,maxi-1);
        root.right = constructMaximumBinaryTree(maxi+1,right);

        return root;
    }
    public TreeNode insertIntoMaxTree2(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);

        if(val > root.val)
            return new TreeNode(val, root, null);

        root.right = insertIntoMaxTree(root.right, val);

        return root;

    }
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || val > root.val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        root.right = insertIntoMaxTree(root.right, val);

        return root;
    }
}