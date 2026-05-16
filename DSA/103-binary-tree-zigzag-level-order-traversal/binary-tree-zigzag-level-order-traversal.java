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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        if(root==null)
        return ans;
        boolean rev = false;
        while(!q.isEmpty()){
            int n =q.size();
            List<Integer> temp = new ArrayList<>();
            while(n>0){
                TreeNode t = q.poll();
                temp.add(t.val);
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
                n--;
            }
            if(!rev)
            ans.add(temp);
            else{
                Collections.reverse(temp);
                ans.add(temp);
            }
            rev=!rev;
        }
        return ans;
    }
}