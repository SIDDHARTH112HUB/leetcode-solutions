class Solution {
    public TreeNode recoverFromPreorder(String s) {
        int i = 0;
        Stack<TreeNode> stack = new Stack<>();

        while (i < s.length()) {
            // Step 1: Count depth (number of consecutive dashes)
            int depth = 0;
            while (i < s.length() && s.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Step 2: Parse the number (multi-digit safe)
            int start = i;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                i++;
            }
            int val = Integer.parseInt(s.substring(start, i));

            // Step 3: Create new node
            TreeNode node = new TreeNode(val);

            // Step 4: Adjust stack to correct depth
            // Pop until stack size == depth
            while (stack.size() > depth) {
                stack.pop();
            }

            // Step 5: Attach node to parent
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) parent.left = node;
                else parent.right = node;
            }

            // Step 6: Push current node
            stack.push(node);
        }

        // Root is the first node pushed
        return stack.get(0);
    }
}

/*
================ DEMO on input: "1-2--3---4-5--6---7" ================

Parse sequence step by step:

1. "1" at depth 0
   -> Root = 1
   Stack = [1]

2. "2" at depth 1
   -> Parent = 1, attach as left
   Tree: 1 → left = 2
   Stack = [1,2]

3. "3" at depth 2
   -> Parent = 2, attach as left
   Tree: 2 → left = 3
   Stack = [1,2,3]

4. "4" at depth 3
   -> Parent = 3, attach as left
   Tree: 3 → left = 4
   Stack = [1,2,3,4]

5. "5" at depth 1
   -> Pop until stack size = 1
   -> Parent = 1, attach as right
   Tree: 1 → right = 5
   Stack = [1,5]

6. "6" at depth 2
   -> Parent = 5, attach as left
   Tree: 5 → left = 6
   Stack = [1,5,6]

7. "7" at depth 3
   -> Parent = 6, attach as left
   Tree: 6 → left = 7
   Stack = [1,5,6,7]

================ FINAL TREE STRUCTURE =================

        1
       / \
      2   5
     /   /
    3   6
   /   /
  4   7

=======================================================
*/
