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
    public List<String> binaryTreePaths1(TreeNode root) {
        ArrayList <String> ans = new ArrayList<>();
        if(root==null) return ans;
        String a = "";
        getPath(root,ans,a);
        return ans;
    }
    public void getPath(TreeNode root,ArrayList <String> ans,String a){
        if(a=="")
        a= ""+root.val;
        else
        a = a+ "->"+root.val;
        
        if(root.left!=null)getPath(root.left,ans,a);
        if(root.right!=null)getPath(root.right,ans,a);
        if(root.left==null && root.right==null)
        {ans.add(a);
        return ;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
         List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
        
    }
     private void helper(List<String> res, TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }
}