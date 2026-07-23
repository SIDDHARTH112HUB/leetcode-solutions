import java.util.*;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] nums) {
        // Example input: nums = [4, 5, 2, 25]

        int[] ans = new int[nums.length]; // result array
        int n = nums.length;

        Stack<Integer> st = new Stack<>(); // stack to track next greater candidates

        int i = n - 1; // start from last element

        while (i >= 0) {
            // Pop all elements smaller or equal to nums[i]
            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }

            // If stack empty → no greater element to the right
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                // Otherwise, top of stack is next greater
                ans[i] = st.peek();
            }

            // Push current element into stack
            st.push(nums[i]);

            // ---- Step-by-step trace for nums = [4, 5, 2, 25] ----
            // Iteration when i = 3 (element = 25):
            //   stack empty → ans[3] = -1, push 25 → stack = [25]
            // Iteration when i = 2 (element = 2):
            //   top = 25 (greater) → ans[2] = 25, push 2 → stack = [25, 2]
            // Iteration when i = 1 (element = 5):
            //   pop 2 (since 5 >= 2), top = 25 → ans[1] = 25, push 5 → stack = [25, 5]
            // Iteration when i = 0 (element = 4):
            //   top = 5 (greater) → ans[0] = 5, push 4 → stack = [25, 5, 4]
            // -----------------------------------------------------

            i--;
        }

        // Convert int[] to ArrayList<Integer>
        ArrayList<Integer> a = new ArrayList<>();
        for (int val : ans) a.add(val);
        return a;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 5, 2, 25};
        ArrayList<Integer> result = sol.nextLargerElement(nums);
        System.out.println(result); // Output: [5, 25, 25, -1]
    }
}
