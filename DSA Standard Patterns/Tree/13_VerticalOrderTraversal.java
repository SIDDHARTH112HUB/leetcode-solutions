import java.util.*; 

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
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

class Solution2 {

    static class Triplet implements Comparable<Triplet>{
        int col;
        int row;
        int val;
        Triplet(int row, int col, int val){
            this.col = col;
            this.row = row;
            this.val = val;
        }

        public int compareTo(Triplet t){
            if(this.col!=t.col){
                return this.col-t.col;
            }
            if(this.row !=t.row){
                return this.row-t.row;
            }
            return this.val-t.val;
        }
    }

    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        dfs(root, 0, 0, pq);
        List<List<Integer>> result = new ArrayList<>();
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int currCol = pq.peek().col;

            while(!pq.isEmpty() && pq.peek().col==currCol){
                temp.add(pq.poll().val);
            }

            result.add(temp);
        }
        
        return result;

    }

    public void dfs(TreeNode root, int row, int col, PriorityQueue<Triplet> pq){
        if(root==null) return;

        pq.add(new Triplet(row,col,root.val));
        dfs(root.left, row+1, col-1, pq);
        dfs(root.right, row+1, col+1, pq);
    }

}