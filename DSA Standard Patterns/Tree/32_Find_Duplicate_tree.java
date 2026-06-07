class Solution {
        Map<String, Integer> count;
    List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        result = new ArrayList<>();
        serialize(root);
        return result;
    }

    private String serialize(TreeNode node) {
        if (node == null) return "#";  // marker for null

        // serialize current subtree
        String serial = node.val + "," + serialize(node.left) + "," + serialize(node.right);

        // count occurrences
        count.put(serial, count.getOrDefault(serial, 0) + 1);

        // add to result only the first time it becomes a duplicate
        if (count.get(serial) == 2) {
            result.add(node);
        }

        return serial;
    }
}