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
    Set<String> set;
    Map<String,TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        set = new HashSet<>();
        ans = new HashMap<>();
        printInOrder(root);
        List<TreeNode> nodeList = new ArrayList<>(ans.values());
        return nodeList;
    }
    void printInOrder(TreeNode node) {
        if (node == null) return;

        printInOrder(node.left);          // Traverse Left
        String s = serialize(node);
        if(set.contains(s)){
            ans.put(s,node);
        }
        else{
            set.add(s);
        }
         // Visit Root
        printInOrder(node.right);         // Traverse Right
    }
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
}