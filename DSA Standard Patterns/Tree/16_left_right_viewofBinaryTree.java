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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)
        return ans; 

        q.add(root);
        int level =1;
        while(!q.isEmpty()){
            int n = q.size();
            while(n-->0){
                TreeNode t = q.poll();
                if(t.left!=null){
                    q.add(t.left);
                }                
                if(t.right!=null){
                    q.add(t.right);
                }
                if(ans.size()<level)
                ans.add(t.val);
                else
                ans.set(level-1,t.val);
            }
            level++;
        }
        
        return ans;
    }
    public List<Integer> leftSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)
        return ans; 

        q.add(root);
        int level =1;
        while(!q.isEmpty()){
            int n = q.size();
            while(n-->0){
                TreeNode t = q.poll();
                if(ans.size()<level)
                ans.add(t.val);
                if(t.left!=null){
                    q.add(t.left);
                }                
                if(t.right!=null){
                    q.add(t.right);
                }
            }
            level++;
        }
        
        return ans;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    private void rightView(TreeNode node, List<Integer> result, int depth) {
        if (node == null) {
            return;
        }

        // If this is the first node we encounter at this depth,
        // it must be the rightmost one (since we go right first).
        if (depth == result.size()) {
            result.add(node.val);
        }

        // Prioritize right subtree first
        rightView(node.right, result, depth + 1);
        rightView(node.left, result, depth + 1);
    }
    
}

