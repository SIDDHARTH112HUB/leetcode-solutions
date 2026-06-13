/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    StringBuilder sb;
    public String serialize(TreeNode root) {
        if(root==null)
        return "";
        sb = new StringBuilder();
        getPreOrder(root);
        return sb.toString();
    }
    void getPreOrder(TreeNode node) {
        if (node == null) return;

        sb.append(node.val + " "); // Visit Root
        getPreOrder(node.left);         // Traverse Left
        getPreOrder(node.right);        // Traverse Right
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")
        return null;
        int[] pre = Arrays.stream(data.split("\\s+"))
                               .mapToInt(Integer::parseInt)
                               .toArray();
        i=0;
        return bstFromPreorder(pre, Integer.MAX_VALUE);
    }
    int i=0;
    
    public TreeNode bstFromPreorder(int[] pre, int upBound) {
        if(i>=pre.length || pre[i]>upBound) return null;

        TreeNode root = new TreeNode(pre[i++]);
        root.left = bstFromPreorder(pre,root.val);
        root.right = bstFromPreorder(pre,upBound);
        return  root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;