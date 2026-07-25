import java.util.*;

class Solution {
    public int maximalRectangle(char[][] m) {
        // Example matrix:
        // [
        //   ['1','0','1','0','0'],
        //   ['1','0','1','1','1'],
        //   ['1','1','1','1','1'],
        //   ['1','0','0','1','0']
        // ]

        int ans = 0;
        int[] arr = new int[m[0].length]; // histogram heights

        // Build histogram row by row
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == '1') {
                    arr[j]++; // increase height
                } else {
                    arr[j] = 0; // reset height
                }
            }
            // For each row, compute largest rectangle in histogram
            ans = Math.max(ans, largestRectangleArea(arr));
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        // Compute largest rectangle in histogram using NSL + NSR
        int[] nsmr = nsr(heights); 
        int[] nsml = nsl(heights); 
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            int width = nsmr[i] - nsml[i] - 1;
            int area = width * heights[i];
            ans = Math.max(ans, area);
        }
        return ans;
    }

    // Nearest Smaller to Left
    public int[] nsl(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    // Nearest Smaller to Right
    public int[] nsr(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
}
