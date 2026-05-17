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
        int key;
        TreeNode node;
        public Pair(int k, TreeNode n){
            key= k;
            node = n;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        if(root==null)
        return ans; 

        q.add(new Pair(0,root));
        int level =0;
        while(!q.isEmpty()){
            int n = q.size();
            while(n-->0){
                Pair t = q.poll();
                int x = t.key;
                mp.computeIfAbsent(x, k -> new TreeMap<>())
                    .computeIfAbsent(level, k -> new PriorityQueue<>())
                    .add(t.node.val);
                if(t.node.left!=null){
                    q.add(new Pair(x-1,t.node.left));
                }                
                if(t.node.right!=null){
                    q.add(new Pair(x+1,t.node.right));
                }
            }
            level++;
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> vl : mp.values()){
            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : vl.values()){
                while(!nodes.isEmpty()){
                    temp.add(nodes.poll());
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}