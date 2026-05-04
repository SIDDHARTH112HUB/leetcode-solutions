class Solution {
    public int maximumRobots(int[] cT, int[] rC, long budget) {
        Deque<Integer> maxTime = new ArrayDeque<>();
        long sum=0;
        int i=0,j=0;
        int ans=0;
        while(j<cT.length){
            sum+=rC[j];
            while(!maxTime.isEmpty()&& cT[maxTime.peekLast()]<=cT[j]){
                maxTime.pollLast();
            }
            maxTime.addLast(j);
            while(i<=j&&!maxTime.isEmpty()&&!isValid(budget,cT[maxTime.peekFirst()],sum,j-i+1)){
                sum-=rC[i];
                
                if(i==maxTime.peekFirst())
                maxTime.pollFirst();
                i++;
            }
            ans=Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
    private boolean isValid(long budget, long max, long sum, long k){
        long total = max+sum*k;
        return total<=budget;
    }
}
// class Solution {
//     public int maximumRobots(int[] cT, int[] rC, long budget) {
//         Deque<Integer> maxTimeIdx = new ArrayDeque<>();
//         long sum = 0; // sum must be long to avoid overflow during calculation
//         int i = 0, j = 0, ans = 0;

//         while (j < cT.length) {
//             sum += rC[j];
            
//             // Maintain monotonic decreasing deque of indices
//             while (!maxTimeIdx.isEmpty() && cT[maxTimeIdx.peekLast()] <= cT[j]) {
//                 maxTimeIdx.pollLast();
//             }
//             maxTimeIdx.addLast(j);

//             // Use your isValid helper to check the budget
//             // Note: maxTimeIdx.peekFirst() gives the index of the max chargeTime
//             while (i <= j && !maxTimeIdx.isEmpty() && !isValid(budget, cT[maxTimeIdx.peekFirst()], sum, j - i + 1)) {
//                 sum -= rC[i];
                
//                 // If the robot we are sliding past (index i) is the current max, remove it
//                 if (maxTimeIdx.peekFirst() == i) {
//                     maxTimeIdx.pollFirst();
//                 }
//                 i++;
//             }

//             ans = Math.max(ans, j - i + 1);
//             j++;
//         }
//         return ans;
//     }

//     private boolean isValid(long budget, long max, long sum, long k) {
//         // total = maxChargeTime + k * sumRunningCosts
//         long total = max + (k * sum);
//         return total <= budget;
//     }
// }