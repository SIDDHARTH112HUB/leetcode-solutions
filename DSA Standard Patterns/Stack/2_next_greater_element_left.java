import java.util.*;

class Solution {
    public ArrayList<Integer> nextLargerElementLeft(int[] nums) {
        // Example input: nums = [4, 5, 2, 25]

        int[] ans = new int[nums.length]; // result array
        int n = nums.length;

        Stack<Integer> st = new Stack<>(); // stack to track candidates

        int i = 0; // IMPORTANT: start from leftmost element (index 0)

        while (i < n) {
            // Pop all elements smaller or equal to nums[i]
            // because they cannot be the "next greater to LEFT"
            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }

            // If stack empty → no greater element exists on the left
            ans[i] = st.isEmpty() ? -1 : st.peek();

            // Push current element into stack for future comparisons
            st.push(nums[i]);

            // ---- Step-by-step trace for nums = [4, 5, 2, 25] ----
            // Iteration i = 0 (element = 4):
            //   stack empty → ans[0] = -1
            //   push 4 → stack = [4]
            //
            // Iteration i = 1 (element = 5):
            //   pop 4 (since 5 >= 4)
            //   stack empty → ans[1] = -1
            //   push 5 → stack = [5]
            //
            // Iteration i = 2 (element = 2):
            //   top = 5 (greater than 2) → ans[2] = 5
            //   push 2 → stack = [5, 2]
            //
            // Iteration i = 3 (element = 25):
            //   pop 2 (25 >= 2), pop 5 (25 >= 5)
            //   stack empty → ans[3] = -1
            //   push 25 → stack = [25]
            // -----------------------------------------------------

            i++;
        }

        // Convert int[] to ArrayList<Integer>
        ArrayList<Integer> a = new ArrayList<>();
        for (int val : ans) a.add(val);
        return a;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 5, 2, 25};
        ArrayList<Integer> result = sol.nextLargerElementLeft(nums);
        System.out.println(result); // Output: [-1, -1, 5, -1]
    }
}
