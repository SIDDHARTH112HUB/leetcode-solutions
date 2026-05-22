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
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode,TreeNode> mp = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>(); 
        q.add(root);
        TreeNode target = new TreeNode(0);;
        while(!q.isEmpty()){
            int n=q.size();
            while(n-->0){
                TreeNode t = q.poll();
                if(t.val ==start)
                target =t;
                if(t.left!=null) {
                    mp.put(t.left,t);
                    q.add(t.left);
                }
                if(t.right!=null){
                    mp.put(t.right,t);
                    q.add(t.right);
                } 
            }
        }
        q.add(target);
        int k=0;
        visited.add(target);
        while(!q.isEmpty()){
            int n=q.size();
            while(n-->0){
                TreeNode t = q.poll();
                if(t.left!=null && !visited.contains(t.left)) {
                    q.add(t.left);
                    visited.add(t.left);
                }
                if(t.right!=null && !visited.contains(t.right)) {
                    q.add(t.right);
                    visited.add(t.right);
                }
                TreeNode par= mp.get(t);
                if(par!=null&& !visited.contains(par)){
                    q.add(par);
                    visited.add(par);
                } 
            }
            k++;
        }
        
        return k-1;
    }
}