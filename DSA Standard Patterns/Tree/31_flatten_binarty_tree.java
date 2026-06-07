class Solution {
    private TreeNode head = null;
    public void flatten(TreeNode root) {
        dfs(root);
    }
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.right);
        dfs(node.left);
        node.left = null;
        node.right = head;
        head = node;

    }

    TreeNode prev = null;
    public void flatten1(TreeNode root) {
        if(root==null)
        return;

        flatten(root.right);
        flatten(root.left);

        root.right=prev;
        root.left = null;
        prev = root;
    }
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);

            if (!stack.isEmpty()) {
                curr.right = stack.peek();
            }
            curr.left = null;
        }
    }
     public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    List<TreeNode> pre;
    public void flatten(TreeNode root) {
        pre = new ArrayList<>();
        if(root==null)
        return;
        printPreOrder(root);
        int i;
        for (i=0;i<pre.size()-1;i++){
            TreeNode t = pre.get(i);
            t.left=null;
            t.right = pre.get(i+1);

        }
        pre.get(i).left=null;
        pre.get(i).right=null;
    }
    void printPreOrder(TreeNode node) {
        if (node == null) return;

        pre.add(node); // Visit Root
        printPreOrder(node.left);         // Traverse Left
        printPreOrder(node.right);        // Traverse Right
    }
}