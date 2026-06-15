class Solution {
    static class State {
        public boolean valid = false;
        public int count = 0;
        public int min = Integer.MAX_VALUE;
        public int max = Integer.MIN_VALUE;

        public State(boolean v, int c) {
            this.valid = v;
            this.count = c;
        }
    }

    static int max;

    static int largestBst(Node root) {
        max = 0; // reset before each run
        valid(root);
        return max;
    }

    public static State valid(Node root) {
        if (root == null) {
            return new State(true, 0) {{
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }};
        }

        State left = valid(root.left);
        State right = valid(root.right);

        State s = new State(false, Math.max(left.count, right.count));

        if (left.valid && right.valid && root.data > left.max && root.data < right.min) {
            s.valid = true;
            s.count = left.count + right.count + 1;
            s.min = (left.count == 0 ? root.data : Math.min(left.min, root.data));
            s.max = (right.count == 0 ? root.data : Math.max(right.max, root.data));
        }

        // Always update global max
        max = Math.max(max, s.count);

        return s;
    }
}
