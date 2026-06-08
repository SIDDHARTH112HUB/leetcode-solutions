class Solution {
    List<Integer> inorderList = new ArrayList<>();

    public List<List<Integer>> closestNodes1(TreeNode root, List<Integer> queries) {
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

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> inorder = new ArrayList<>();

        // Step 1: Convert BST to sorted list
        inorderTraversal(root, inorder);

        List<List<Integer>> result = new ArrayList<>();

        // Step 2: Process each query
        for (int q : queries) {
            int floor = getFloor(inorder, q);
            int ceil = getCeil(inorder, q);

            result.add(Arrays.asList(floor, ceil));
        }

        return result;
    }

    // Inorder traversal → sorted list
    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    // Binary search for floor (largest <= q)
    private int getFloor(List<Integer> list, int q) {
        int left = 0, right = list.size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) <= q) {
                ans = list.get(mid);
                left = mid + 1; // try bigger
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    // Binary search for ceil (smallest >= q)
    private int getCeil(List<Integer> list, int q) {
        int left = 0, right = list.size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) >= q) {
                ans = list.get(mid);
                right = mid - 1; // try smaller
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
