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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)
        return ans; 

        q.add(root);
        int level =1;
        while(!q.isEmpty()){
            int n = q.size();
            while(n-->0){
                TreeNode t = q.poll();
                if(t.left!=null){
                    q.add(t.left);
                }                
                if(t.right!=null){
                    q.add(t.right);
                }
                if(ans.size()<level)
                ans.add(t.val);
                else
                ans.set(level-1,t.val);
            }
            level++;
        }
        
        return ans;
    }
}