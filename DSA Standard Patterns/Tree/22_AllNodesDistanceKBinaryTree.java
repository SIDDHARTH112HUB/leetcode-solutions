class Solution {
    class Pair {
        TreeNode par;  // actual tree node
        TreeNode node;  // actual tree node
        public Pair(TreeNode root, TreeNode baap) {
            node = root;
            par = baap;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode,TreeNode> mp = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>(); 
        q.add(root);

        while(!q.isEmpty()){
            int n=q.size();
            while(n-->0){
                TreeNode t = q.poll();
                if(t.left!=null) {
                    mp.put(t.left,t);
                    q.add(t.left);
                }
                if(t.right!=null){
                    mp.put(t.right,t);
                    q.add(t.right);
                } 
            }
        }
        q.add(target);

        visited.add(target);
        while(k>0 && !q.isEmpty()){
            int n=q.size();
            while(n-->0){
                TreeNode t = q.poll();
                if(t.left!=null && !visited.contains(t.left)) {
                    q.add(t.left);
                    visited.add(t.left);
                }
                if(t.right!=null && !visited.contains(t.right)) {
                    q.add(t.right);
                    visited.add(t.right);
                }
                TreeNode par= mp.get(t);
                if(par!=null&& !visited.contains(par)){
                    q.add(par);
                    visited.add(par);
                } 
            }
            k--;
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}