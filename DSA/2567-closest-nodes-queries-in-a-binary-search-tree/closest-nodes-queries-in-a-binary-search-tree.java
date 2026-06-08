class Solution {
    List<Integer> inorderList = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        // Step 1: Inorder traversal to get sorted values
        inorder(root);

        List<List<Integer>> ans = new ArrayList<>();
        for (int q : queries) {
            ans.add(findClosest(q));
        }
        return ans;
    }

    // Step 2: Inorder traversal (BST -> sorted list)
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }

    // Step 3: Binary search for floor & ceil
    private List<Integer> findClosest(int target) {
        int floor = -1, ceil = -1;
        int idx = Collections.binarySearch(inorderList, target);

        if (idx >= 0) {
            // Exact match
            floor = inorderList.get(idx);
            ceil = inorderList.get(idx);
        } else {
            // insertion point
            int insertPoint = -(idx + 1);

            if (insertPoint < inorderList.size()) {
                ceil = inorderList.get(insertPoint);
            }
            if (insertPoint > 0) {
                floor = inorderList.get(insertPoint - 1);
            }
        }

        return Arrays.asList(floor, ceil);
    }
}
