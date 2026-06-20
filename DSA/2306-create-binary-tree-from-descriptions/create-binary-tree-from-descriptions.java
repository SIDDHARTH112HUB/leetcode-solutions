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
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode root =null;
        Map<Integer, TreeNode> mp = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for(int[] desc: descriptions){
            int par = desc[0];
            int child = desc[1];
            boolean left = desc[2]==1;

            TreeNode p = mp.containsKey(par)?mp.get(par):new TreeNode(par);
            TreeNode c = mp.containsKey(child)?mp.get(child):new TreeNode(child);

            mp.put(par,p);
            mp.put(child,c);

            if(left==true){
                p.left = c;
            }
            else{
                p.right =c;
            }
            if(root == null)
            root = p;
            
            children.add(child);

        }
        for (int key : mp.keySet()) {
            if (!children.contains(key)) {
                return mp.get(key);
            }
        }
        return null;

    }
}