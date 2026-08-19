/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> num = new ArrayList<>();
        while(head!=null){
            num.add(head.val);
            head = head.next;
        }
        return nextLargerElement(num.stream().mapToInt(Integer::intValue).toArray());
    }
    public int[] nextLargerElement(int[] nums) {
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
                ans[i] = 0;
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
        return ans;
    }
}