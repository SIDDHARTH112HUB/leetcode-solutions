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
    public TreeNode reverseOddLevels(TreeNode root) {
        List<List<TreeNode>> temp = levelOrderGroups(root);
        for(int i=0;i<temp.size()-1;i++){
            if (i % 2 == 0) { // reverse odd rows (1, 3, 5...)
                Collections.reverse(temp.get(i+1));
            }
            for(int j=0;j<temp.get(i).size();j++){
                TreeNode t = temp.get(i).get(j);
                t.left = temp.get(i+1).get(2*j);
                t.right = temp.get(i+1).get(2*j+1);
            }
        }
        return root;
    }
    public List<List<TreeNode>> levelOrderGroups(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Number of nodes at the current level
            int levelSize = queue.size();
            List<TreeNode> currentLevelList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode tempNode = queue.poll();
                currentLevelList.add(tempNode);

                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
            
            // Add the completed level to the final list
            result.add(currentLevelList);
        }
        return result;
    }
}