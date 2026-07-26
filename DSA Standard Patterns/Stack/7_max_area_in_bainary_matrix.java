class Solution {
    public int maximalRectangle(char[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        int maxArea = 0;

        // Try every possible rectangle
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (m[i][j] == '1') {
                    // Expand rectangle from (i,j)
                    for (int k = i; k < rows; k++) {
                        for (int l = j; l < cols; l++) {
                            if (isAllOnes(m, i, j, k, l)) {
                                int area = (k - i + 1) * (l - j + 1);
                                maxArea = Math.max(maxArea, area);
                            }
                        }
                    }
                }
            }
        }
        return maxArea;
    }

    // Helper to check if rectangle is all '1'
    private boolean isAllOnes(char[][] m, int i, int j, int k, int l) {
        for (int r = i; r <= k; r++) {
            for (int c = j; c <= l; c++) {
                if (m[r][c] == '0') return false;
            }
        }
        return true;
    }
}

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
