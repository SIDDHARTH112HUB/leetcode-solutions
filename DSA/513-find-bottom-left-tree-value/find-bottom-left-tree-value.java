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
    public int findBottomLeftValue1(TreeNode root) {
        if (root == null) return -1;
        int ans = root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Number of nodes at the current level
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            ans= queue.peek().val;
            for (int i = 0; i < levelSize; i++) {
                TreeNode tempNode = queue.poll();
               

                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
            
            // Add the completed level to the final list
    
        }
        return ans;
    }
    int maxDepth=-1,value=0;
    public void dfs(TreeNode root,int level){
        if(root==null) return ;
        if(level>maxDepth){
            maxDepth=level;
            value=root.val;
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);

    }
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return value;
    }
}