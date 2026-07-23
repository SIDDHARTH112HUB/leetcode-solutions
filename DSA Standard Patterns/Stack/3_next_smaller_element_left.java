import java.util.*;

class Solution {
    public static ArrayList<Integer> prevSmaller(int[] nums) {
        // Example input: nums = [4, 5, 2, 25]

        int[] ans = new int[nums.length]; // result array
        int n = nums.length;

        Stack<Integer> st = new Stack<>(); // stack to track candidates

        int i = 0; // start from leftmost element

        while (i < n) {
            // Pop all elements greater or equal to nums[i]
            // because they cannot be the "previous smaller"
            while (!st.isEmpty() && nums[i] <= st.peek()) {
                st.pop();
            }

            // If stack empty → no smaller element exists on the left
            ans[i] = st.isEmpty() ? -1 : st.peek();

            // Push current element into stack for future comparisons
            st.push(nums[i]);

            // ---- Step-by-step trace for nums = [4, 5, 2, 25] ----
            // Iteration i = 0 (element = 4):
            //   stack empty → ans[0] = -1
            //   push 4 → stack = [4]
            //
            // Iteration i = 1 (element = 5):
            //   top = 4 (smaller than 5) → ans[1] = 4
            //   push 5 → stack = [4, 5]
            //
            // Iteration i = 2 (element = 2):
            //   pop 5 (since 2 <= 5), pop 4 (since 2 <= 4)
            //   stack empty → ans[2] = -1
            //   push 2 → stack = [2]
            //
            // Iteration i = 3 (element = 25):
            //   top = 2 (smaller than 25) → ans[3] = 2
            //   push 25 → stack = [2, 25]
            // -----------------------------------------------------

            i++;
        }

        // Convert int[] to ArrayList<Integer>
        ArrayList<Integer> a = new ArrayList<>();
        for (int val : ans) a.add(val);
        return a;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 25};
        ArrayList<Integer> result = prevSmaller(nums);
        System.out.println(result); // Output: [-1, 4, -1, 2]
    }
}
