import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();
    private boolean reverse;

    // reverse = false → inorder (smallest to largest)
    // reverse = true  → reverse inorder (largest to smallest)
    public BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        TreeNode node = st.pop();
        if (!reverse) {
            pushAll(node.right);
        } else {
            pushAll(node.left);
        }
        return node.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = reverse ? node.right : node.left;
        }
    }
}

public class TwoSumBST {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        BSTIterator l = new BSTIterator(root, false);  // smallest
        BSTIterator r = new BSTIterator(root, true);   // largest

        int i = l.next();
        int j = r.next();

        while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) {
                if (l.hasNext()) i = l.next();
                else return false;
            } else {
                if (r.hasNext()) j = r.next();
                else return false;
            }
        }
        return false;
    }

    // Example usage
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TwoSumBST solver = new TwoSumBST();
        System.out.println(solver.findTarget(root, 9));  // true (2+7)
        System.out.println(solver.findTarget(root, 28)); // false
    }
}



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
    public void inOrder(TreeNode root,ArrayList<TreeNode> lst){
        if(root == null) return ;
        inOrder(root.left,lst);
        lst.add(root);
        inOrder(root.right,lst);
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<TreeNode> lst = new ArrayList<>();
        inOrder(root,lst);
        int i= 0;
        int j  = lst.size()-1;

        while(i<j){
         int sum = lst.get(i).val+ lst.get(j).val;
         if(sum>k){
            j--;
         }else if(sum<k){
            i++;
         }else{
            return true;
         }
        }
        return false;
    }
}