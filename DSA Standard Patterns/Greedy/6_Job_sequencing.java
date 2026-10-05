// O(N^2) solution  
// for each job, we check for the latest available slot before its deadline.
// If we find an available slot, we schedule the job and update the total profit and count of jobs scheduled.
class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        for(int i=0;i<deadline.length;i++){
            max = Math.max(max,deadline[i]);
            pq.add(new int[]{profit[i],deadline[i]});
        }
        int [] ab = new int [max+1];
        int count = 0;
        int total = 0;
        while(!pq.isEmpty()){
            int [] t= pq.poll();
            int i = t[1];
            while(i-->0){
                if(ab[i]==0){
                    ab[i]=t[0];
                    count++;
                    total+=t[0];
                    break;
                }
            }
        }
        ArrayList<Integer> ans= new ArrayList<>();
        ans.add(count);
        ans.add(total);
        return ans;
    }
}


// O(NlogN) solution
// Using Disjoint Set Union (DSU) to efficiently find the latest available slot for each job.
//DSU allows us to keep track of the next available slot for each job, reducing the time complexity to O(NlogN).
// DSU is used to find the latest available slot for each job. Each slot is represented as a node in the DSU, and we can efficiently find the next available slot using path compression.
// DSU is a data structure that allows us to efficiently manage a collection of disjoint sets and perform union and find operations. In this case, we use it to keep track of the available slots for scheduling jobs.
// Disjoint Set Union (DSU) is a data structure that allows us to efficiently manage a collection of disjoint sets and perform union and find operations. 
// In this case, we use it to keep track of the available slots for scheduling jobs. Each slot is represented as a node in the DSU, and we can efficiently find the next available slot using path compression.
class Solution {
    int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        PriorityQueue<int[]> pq =  new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{profit[i], deadline[i]});
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }
        int[] parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }
        int count = 0;
        int total = 0;
        while (!pq.isEmpty()) {
            int[] job = pq.poll();
            int profitValue = job[0];
            int deadlineValue = job[1];
            // Find latest available slot <= deadline
            int slot = find(parent, deadlineValue);
            if (slot > 0) {
                count++;
                total += profitValue;
                // Mark this slot as occupied.
                // Next time, go to the previous available slot.
                parent[slot] = find(parent, slot - 1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(total);

        return ans;
    }
}