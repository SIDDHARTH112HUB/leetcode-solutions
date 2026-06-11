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
    public TreeNode bstFromPreorder1(int[] preorder) {
        int []in = Arrays.copyOf(preorder, preorder.length);
        
        // Sort the array in ascending order
        Arrays.sort(in);

        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<in.length;i++){
            inMap.put(in[i],i);
        }
        return buildTree(preorder,0,preorder.length-1,in,0,in.length-1,inMap);   
    }

    public TreeNode buildTree(int[] pre,int preStart,int preEnd,int[] in, int inStart, int inEnd,Map<Integer,Integer> inMap){
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);

        int inRoot = inMap.get(pre[preStart]);
        int numLeft = inRoot-inStart;

        root.left = buildTree(pre,preStart+1, preStart+numLeft,in,inStart,inRoot-1,inMap);
        root.right = buildTree(pre,preStart+numLeft+1, preEnd,in,inRoot+1,inEnd,inMap);

        return root;
    }
    int i=0;
    public TreeNode bstFromPreorder(int[] pre) {
        return  bstFromPreorder(pre,Integer.MAX_VALUE);
    }
    public TreeNode bstFromPreorder(int[] pre, int upBound) {
        if(i>=pre.length || pre[i]>upBound) return null;

        TreeNode root = new TreeNode(pre[i++]);
        root.left = bstFromPreorder(pre,root.val);
        root.right = bstFromPreorder(pre,upBound);
        return  root;
    }
}