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
    class Pair{
        long num;
        TreeNode node;
        public Pair(TreeNode root, long n){
            node =root;
            num = n;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q = new ArrayDeque<>();

        long ans =0;

        if(root==null)
        return (int)ans;
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int n = q.size();
            long st = q.peekFirst().num;
            long end = q.peekLast().num;
            ans = Math.max(ans, end-st+1);
            while(n-->0){
                Pair t = q.poll();
                if(t.node.left!=null){
                    q.add(new Pair(t.node.left, 2*t.num+1));
                }

                if(t.node.right!=null){
                    q.add(new Pair(t.node.right, 2*t.num+2));
                }
            }

        }
        return (int)ans;
    }
}