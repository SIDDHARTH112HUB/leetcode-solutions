class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {

        // Stores exclusive execution time for each function
        int[] ans = new int[n];

        // Keeps track of currently executing functions
        Stack<Integer> st = new Stack<>();

        // Current timestamp from which active function is running
        int ct = 0;

        for (String s : logs) {

            // Split log into id, state and timestamp
            String[] l = s.split(":");

            int functionId = Integer.parseInt(l[0]);
            String state = l[1];
            int time = Integer.parseInt(l[2]);

            // Function starts
            if (state.equals("start")) {

                // Previous function executes until this timestamp
                if (!st.empty()) {
                    ans[st.peek()] += time - ct;
                }

                // New function becomes active
                st.push(functionId);

                // Update current time
                ct = time;
            }

            // Function ends
            else {

                // End timestamp is inclusive (+1)
                ans[functionId] += time - ct + 1;

                // Remove completed function
                st.pop();

                // Next execution begins after current timestamp
                ct = time + 1;
            }
        }

        return ans;
    }
}