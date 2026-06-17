class Solution {
    List<Integer> num;
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        num = new ArrayList<>();
        printInOrder(root);
        num.add(val);
        return constructMaximumBinaryTree(0,num.size()-1);
    }
    void printInOrder(TreeNode node) {
        if (node == null) return;

        printInOrder(node.left);          // Traverse Left
        num.add(node.val); // Visit Root
        printInOrder(node.right);         // Traverse Right
    }
    public TreeNode constructMaximumBinaryTree(int left, int right) {
        if(left>right)
        return null;

        int maxi=left;
        int max=num.get(left);
        for(int i=left;i<=right;i++){
            if(max<num.get(i)){
                max= num.get(i);
                maxi=i;
            }
        }
        TreeNode root = new TreeNode(num.get(maxi));
        root.left = constructMaximumBinaryTree(left,maxi-1);
        root.right = constructMaximumBinaryTree(maxi+1,right);

        return root;
    }
}