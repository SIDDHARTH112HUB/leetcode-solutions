import java.util.*;

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] nums) {
        // Example input: nums = [4, 5, 2, 25]

        int[] ans = new int[nums.length]; // result array
        int n = nums.length;

        Stack<Integer> st = new Stack<>(); // stack to track candidates

        int i = n - 1; // start from rightmost element

        while (i >= 0) {
            // Pop all elements greater or equal to nums[i]
            // because they cannot be the "next smaller to RIGHT"
            while (!st.isEmpty() && nums[i] <= st.peek()) {
                st.pop();
            }

            // If stack empty → no smaller element exists on the right
            ans[i] = st.isEmpty() ? -1 : st.peek();

            // Push current element into stack for future comparisons
            st.push(nums[i]);

            // ---- Step-by-step trace for nums = [4, 5, 2, 25] ----
            // Iteration i = 3 (element = 25):
            //   stack empty → ans[3] = -1
            //   push 25 → stack = [25]
            //
            // Iteration i = 2 (element = 2):
            //   pop 25 (since 2 <= 25)
            //   stack empty → ans[2] = -1
            //   push 2 → stack = [2]
            //
            // Iteration i = 1 (element = 5):
            //   top = 2 (smaller than 5) → ans[1] = 2
            //   push 5 → stack = [2, 5]
            //
            // Iteration i = 0 (element = 4):
            //   pop 5 (since 4 <= 5)
            //   top = 2 (smaller than 4) → ans[0] = 2
            //   push 4 → stack = [2, 4]
            // -----------------------------------------------------

            i--;
        }

        // Convert int[] to ArrayList<Integer>
        ArrayList<Integer> a = new ArrayList<>();
        for (int val : ans) a.add(val);
        return a;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 25};
        ArrayList<Integer> result = nextSmallerEle(nums);
        System.out.println(result); // Output: [2, 2, -1, -1]
    }
}
