// Brute Force Approach
// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;
        if (n == 0) return 0;

        int maxPlatforms = 1;

        // Check each train against every other train
        for (int i = 0; i < n; i++) {
            int overlappingTrains = 1; // Count train i itself

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    // Check if train j overlaps with train i
                    // Overlap condition: arr[i] <= dep[j] && arr[j] <= dep[i]
                    if (arr[i] <= dep[j] && arr[j] <= dep[i]) {
                        overlappingTrains++;
                    }
                }
            }

            maxPlatforms = Math.max(maxPlatforms, overlappingTrains);
        }

        return maxPlatforms;
    }
}

// Optimized Approach
// Time Complexity: O(n log n) due to sorting
// Space Complexity: O(n) for storing events in the priority queue
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int ans =1;
        int cnt =0;
        PriorityQueue<int[]> mnh = new PriorityQueue<>(
                    (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
                );
        for(int i:arr){
            mnh.add(new int[]{i,0});
        }
        for(int i:dep){
            mnh.add(new int[]{i,1});
        }
        while(mnh.size()>0){
            int [] d = mnh.poll();
            if(d[1]==1){
                cnt--;
            }
            else{
                cnt++;
            }
            ans =Math.max(cnt,ans);
        }
        return ans;
    }
}

// Another Optimized Approach
// Time Complexity: O(n log n) due to sorting
// Space Complexity: O(1) if we sort in place, otherwise O(n) for storing sorted arrays
// This approach uses two pointers to traverse the sorted arrival and departure times


class Solution {
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;
        if (n == 0) return 0;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int count = 0;
        int maxPlatforms = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            // When arrival time <= departure time, a platform is needed
            if (arr[i] <= dep[j]) {
                count++;
                maxPlatforms = Math.max(maxPlatforms, count);
                i++;
            } else {
                // Train departs, platform freed
                count--;
                j++;
            }
        }

        return maxPlatforms;
    }
}