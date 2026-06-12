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
    public void BSTIterator1(TreeNode root) {
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
    public int next1() {
        return in.get(i++);
         
    }
    public boolean hasNext1() {
        return i<in.size();
    }
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        fillLeft(root);
    }
    void fillLeft(TreeNode node) {
        if (node == null) return;
        while(node!=null){
            st.push(node);
            node = node.left;
        }        // Traverse Right
    }
    public int next() {
        TreeNode node = st.pop();
        fillLeft(node.right);
        return node.val;
         
    }
    
    public boolean hasNext() {
        return !st.empty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */