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
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return false;

        boolean result = true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level =0;
        while (!queue.isEmpty()) {
            // Number of nodes at the current level
            int levelSize = queue.size();
            List<Integer> values = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode tempNode = queue.poll();
                values.add(tempNode.val);

                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
            if(level%2==0){
                result = strictlyIncreasingOdd(values);
            }
            else
                result = strictlyDecreasingEven(values);
            if(result==false)
            return false;
            level++;
        }
        return true;
    }
    boolean strictlyIncreasingOdd(List<Integer> v){
        if(v.get(0)%2==0)
        return false;

        for(int i=1;i<v.size();i++){
            if(v.get(i)%2==0 || v.get(i)<=v.get(i-1))
            return false;
        }
        return true;
    }
    boolean strictlyDecreasingEven(List<Integer> v){
        if(v.get(0)%2==1)
        return false;

        for(int i=1;i<v.size();i++){
            if(v.get(i)%2==1 || v.get(i)>=v.get(i-1))
            return false;
        }
        return true;
    }
}