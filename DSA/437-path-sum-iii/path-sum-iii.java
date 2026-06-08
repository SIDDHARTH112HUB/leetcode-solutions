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
    public int pathSum1(TreeNode root, int targetSum) {
        if(root==null)
        return 0;

        int left = pathSum1(root.left,targetSum);
        int right = pathSum1(root.right, targetSum);

        return left+right+ pathSum2(root,targetSum);
    }
    public int pathSum2(TreeNode root, long s){
        if(root==null)
        return 0;

        int count=0;
        if(root.val==s)
        count=1;

        count+=pathSum2(root.left, s-root.val);
        count+=pathSum2(root.right, s-root.val);

        return count;
        
    }
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // base case: one way to have sum = 0
        return dfs(root, 0L, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currSum, int target, HashMap<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        // Update current prefix sum
        currSum += node.val;

        // Count paths ending at current node
        int res = prefixSumCount.getOrDefault(currSum - target, 0);

        // Add current sum into hashmap
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        // Recurse left and right
        res += dfs(node.left, currSum, target, prefixSumCount);
        res += dfs(node.right, currSum, target, prefixSumCount);

        // Backtrack: remove current sum
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

        return res;
    }
}