class Solution {
    public int numberOfSubarraysM1UsingQueue(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        int i=0,j=0,ans=0;
        while(j<nums.length){
            if(nums[j]%2==1)
            q.add(j);
            while(q.size()>k){
                i=q.poll()+1;
                
            }
            if(q.size()==k){
                ans+=q.peek()-i+1;
            }
            j++;

        }
        return ans;
    }
    public int numberOfSubarraysUsingArrays(int[] nums, int k) {
        int count=0;
        List<Integer> q = new ArrayList<>();
        int i=0,j=0,ans=0;
        while(j<nums.length){
            if(nums[j]%2==1)
            {   
                q.add(j);
                count++;
            }
            if(count>k){
                i=q.get(q.size()-count)+1;
                count--;
            }
            if(count==k){
                ans+=q.get(q.size()-count)-i+1;
            }
            j++;

        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int i = 0, ans = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 1) k--;

            while (k < 0) {
                if (nums[i] % 2 == 1) k++;
                i++;
            }

            ans += j - i + 1;
        }

        return ans;
    }
}