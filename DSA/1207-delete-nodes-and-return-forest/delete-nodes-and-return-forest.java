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
    public List<TreeNode> delNodes1(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int x : to_delete) {
            set.add(x);
        }
        delete(ans, root,root.left,set);
        delete(ans, root,root.right,set);
        if(set.contains(root.val)){
            if(root.left!=null){
                ans.add(root.left);
            }            
            if(root.right!=null){
                ans.add(root.right);
            }
        }
        else{
            ans.add(root);
        }
        return ans;
    }
    void delete(List<TreeNode> ans, TreeNode par, TreeNode root, Set<Integer> set){
        if(root==null)
        return;

        delete(ans,root,root.left,set);
        delete(ans,root,root.right,set);

        if(set.contains(root.val)){
            if(root.left!=null){
                ans.add(root.left);
            }            
            if(root.right!=null){
                ans.add(root.right);
            }
            if(par.left!=null && par.left.val==root.val)
            par.left=null;
            else if(par.right!=null &&  par.right.val==root.val)
            par.right =null;
        }
    }



    //M-2

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int x : to_delete) set.add(x);

        dfs(root, true, set, ans);
        return ans;
    }

    private TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> set, List<TreeNode> ans) {
        if (node == null) return null;

        boolean deleted = set.contains(node.val);
        if (isRoot && !deleted) ans.add(node);

        node.left = dfs(node.left, deleted, set, ans);
        node.right = dfs(node.right, deleted, set, ans);

        return deleted ? null : node;
    }
}