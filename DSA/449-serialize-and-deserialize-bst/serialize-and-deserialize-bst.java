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
    public String serialize(TreeNode root) {
        if(root==null)
        return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp==null){
                sb.append("n ");
                continue;
            }
            else{
                sb.append(temp.val+" ");
            }
            q.add(temp.left);
            q.add(temp.right);
        } 
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="")
        return null;
        String []v = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(v[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i=1;i<v.length;i++){
            TreeNode temp = q.poll();
            if(!v[i].equals("n")){
                temp.left = new TreeNode(Integer.parseInt(v[i]));
                q.add(temp.left);
            }
            if(!v[++i].equals("n")){
                temp.right = new TreeNode(Integer.parseInt(v[i]));
                q.add(temp.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;