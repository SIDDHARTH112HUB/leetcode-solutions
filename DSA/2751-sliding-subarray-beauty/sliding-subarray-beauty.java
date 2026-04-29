class Solution {
    // M1 - TLE
    // public int[] getSubarrayBeauty(int[] arr, int k, int x) {
    //     // write code here
    //     int i=0,j=0;
    //     List<Integer> ans = new ArrayList<>();
    //     Queue<Integer> temp = new LinkedList<>();
    //     while(j<arr.length){
    //         if(arr[j]<0){
    //             temp.add(arr[j]);
    //         }
    //         if(j-i+1==k){
    //             ans.add(getXthSmallest(temp,x));
    //             if(arr[i]<0){
    //                 temp.poll();
    //             }
    //             i++;
    //         }
    //         j++;
    //     }
    //     int[] numberArray = ans.stream()
    //                                   .mapToInt(Integer::intValue) // Unbox Integer to int
    //                                   .toArray();
    //     return numberArray;
    // }
    // public static Integer getXthSmallest(Queue<Integer> pq, int x) {
    //     if (x <= 0 || x > pq.size()) return 0; 
    //     // Invalid request
    //     List<Integer> list = new ArrayList<>(pq); // Copy elements
    //     Collections.sort(list); // Sort ascending
    //     if(x<=list.size())
    //     return list.get(x - 1); // X-th smallest

    //     return 0;
    // }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] freq = new int[51]; // freq[i] = count of -i in window
        
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] < 0) freq[-nums[j]]++;
            
            if (j - i + 1 == k) {
                res[i] = getXthSmallest(freq, x);
                if (nums[i] < 0) freq[-nums[i]]--;
                i++;
            }
        }
        return res;
    }
    
    private int getXthSmallest(int[] freq, int x) {
        int count = 0;
        for (int v = 50; v >= 1; v--) { // check -50 to -1
            count += freq[v];
            if (count >= x) return -v;
        }
        return 0; // fewer than x negatives
    }
}

