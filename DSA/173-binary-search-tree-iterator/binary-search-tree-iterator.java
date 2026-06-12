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
class BSTIterator {
    int i=0;
    List<Integer> in;
    public BSTIterator(TreeNode root) {
        in = new ArrayList<>();
        inOrder(root);
        i=0;  
    }
    void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);          // Traverse Left
        in.add(node.val); // Visit Root
        inOrder(node.right);         // Traverse Right
    }
    public int next() {
        return in.get(i++);
         
    }
    
    public boolean hasNext() {
        return i<in.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */