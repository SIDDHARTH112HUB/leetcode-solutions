class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int day=0;          // keeps track of current day index
        Stack<Pair> st= new Stack<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int price:arr){
            while (!st.isEmpty() && price >= st.peek().value) {
                st.pop();
            }
            
            int span;
            if (st.isEmpty()) {
                // No greater price to the left → span covers all days so far
                span = day + 1;
            } else {
                // Span is distance to last greater price
                span = day - st.peek().index;
            }
            // Push current price with its day index
            st.push(new Pair(price, day));
            day++;
    
            ans.add(span);
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
