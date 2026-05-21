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
    TreeNode ans;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ans=null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int tn =0;
        int level=0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            tn = levelSize;

            for (int i = 0; i < levelSize; i++) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
            level++;
        }
        //System.out.print(level);
        getTreeNodeCount(root,tn,level);
        return ans;
    }
    public int getTreeNodeCount(TreeNode root, int total,int level){
        if(root.left==null && root.right==null){
            if(level==1)
            {
                if(total==1)
                ans=root;
                return 1;
            }
            else 
            return 0;
        }
        int left =0,right=0;
        if(root.left!=null )
        left=getTreeNodeCount(root.left,total,level-1);
        
        if(root.right!=null)
        right =getTreeNodeCount(root.right,total,level-1);
        // System.out.print(root.val+ " ");
        // System.out.print(left +" ");
        // System.out.print(right +" ");
        //System.out.println(" ");
        
        if(left+right==total && ans==null){
            ans=root;
         //System.out.print(ans.val+ " -ans ");
        }

         //System.out.println(level + " - level ");
        return left+right;

    }
}