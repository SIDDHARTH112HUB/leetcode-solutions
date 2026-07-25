class Solution {
    public int largestRectangleArea(int[] heights) {
        int [] nsmr = nsr(heights); 
        int [] nsml = nsl(heights); 
        int ans = Integer.MIN_VALUE;
        for(int i =0;i<heights.length;i++){
            int w = nsmr[i]-nsml[i]-1;
            int area = w*heights[i];
            ans= Math.max(ans,area);
        }
        return ans;
    }
    public int[] nsl(int[] nums) {
        int[] ans = new int[nums.length]; // result array
        int n = nums.length;

        Stack<Integer> st = new Stack<>(); // stack to track candidates

        int i = 0; // start from leftmost element

        while (i < n) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
            i++;
        }
        return ans;
    }
    public int[] nsr(int[] nums) {
        int[] ans = new int[nums.length]; // result array
        int n = nums.length;

        Stack<Integer> st = new Stack<>(); // stack to track candidates

        int i = n-1; // start from leftmost element

        while (i >= 0) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
            i--;
        }
        return ans;
    }
}
class Pair {
    int value;
    int index;
    public Pair(int v, int i) {
        value = v;
        index = i;
    }
}