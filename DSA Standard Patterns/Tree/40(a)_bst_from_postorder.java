int i; // global index

public TreeNode bstFromPostorder(int[] post) {
    i = post.length - 1; // start from the end
    return bstFromPostorder(post, Integer.MIN_VALUE);
}

public TreeNode bstFromPostorder(int[] post, int lowBound) {
    if (i < 0 || post[i] < lowBound) return null;

    TreeNode root = new TreeNode(post[i--]);
    // build right subtree first (since we’re going backwards)
    root.right = bstFromPostorder(post, root.val);
    root.left = bstFromPostorder(post, lowBound);
    return root;
}
