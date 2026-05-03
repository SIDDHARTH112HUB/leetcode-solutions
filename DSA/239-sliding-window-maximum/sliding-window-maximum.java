class Solution {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        // write code here
        int i=0,j=0;
        int imax=0,jmax=0, max=Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> temp = new TreeMap<>();
        while(j<nums.length){
            temp.merge(nums[j],1,Integer::sum); 
            if(j-i+1==k){
                ans.add(temp.lastKey());
                temp.computeIfPresent(nums[i],(ki,v)->(v>1)?v-1:null);
                i++;
            }
            j++;
        }
        
        int[] numberArray = ans.stream()
                                      .mapToInt(Integer::intValue) // Unbox Integer to int
                                      .toArray();
        return numberArray;
        
    }
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> dq= new ArrayDeque<>();
        int [] res= new int[nums.length-k+1];
        for(int i=0; i<k; i++){
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            dq.offerLast(i);
        };
            res[0]=nums[dq.peekFirst()];
        for(int i=k; i<nums.length; i++){
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            dq.offerLast(i);
            if (dq.peekFirst() < i - k + 1)
                dq.pollFirst();
            res[i-k+1]=nums[dq.peekFirst()];
        }
        return res;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q= new ArrayDeque<>();
        int [] res= new int[nums.length-k+1];
        int i=0,j=0,t=0;
        while(j<nums.length){
            while(!q.isEmpty()&& q.peekLast()<nums[j]){
                q.pollLast();
            }
            q.addLast(nums[j]);
            
            //System.out.println("j :"+j+ " max: "+q.peek());
            if(j-i+1==k){
                res[t++]=q.peekFirst();
                //System.out.println("i :"+i+ " max: "+q.peek());
                if(nums[i]==q.peekFirst())
                q.pollFirst();
                i++;
            }
            j++;
            
            
        }
        return res;
        }
}
