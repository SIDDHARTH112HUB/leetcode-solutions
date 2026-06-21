class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i < nums.length;i++){
            int a = nums[i];
            if(nums[Math.abs(a)-1]<0)
            return Math.abs(a);
            nums[Math.abs(nums[i]) - 1] *= -1;
        }
        return -1;
    }

    // its like cycle detection in linked list, we are treating the values as pointers to indices
    // and since there is a duplicate, it creates a cycle in the "linked list" formed by the indices and values
    // we use the Floyd's Tortoise and Hare algorithm to detect the cycle and find the duplicate number
    // Time complexity: O(n), Space complexity: O(1)
    public int findDuplicate(int[] nums) {
        // Example input: nums = {1, 3, 4, 2, 2}
        // Duplicate is 2

        int slow = 0, fast = 0;

        // Phase 1: Detect cycle
        while (true) {
            slow = nums[slow];          // move slow by 1 step
            fast = nums[nums[fast]];    // move fast by 2 steps

            // Dry run:
            // Iteration 1: slow=nums[0]=1, fast=nums[nums[0]]=nums[1]=3
            // Iteration 2: slow=nums[1]=3, fast=nums[nums[3]]=nums[2]=4
            // Iteration 3: slow=nums[3]=2, fast=nums[nums[4]]=nums[2]=4
            // Iteration 4: slow=nums[2]=4, fast=nums[nums[4]]=nums[2]=4
            // => slow == fast (both 4), cycle detected
            if (slow == fast) {
                break;
            }
        }

        // Phase 2: Find entry point of cycle (duplicate number)
        int slow2 = 0; // start from index 0 again
        while (true) {
            slow = nums[slow];      // move slow by 1 step
            slow2 = nums[slow2];    // move slow2 by 1 step

            // Dry run:
            // Iteration 1: slow=nums[4]=2, slow2=nums[0]=1
            // Iteration 2: slow=nums[2]=4, slow2=nums[1]=3
            // Iteration 3: slow=nums[4]=2, slow2=nums[3]=2
            // => slow == slow2 == 2, duplicate found
            if (slow == slow2) {
                return slow; // return duplicate number
            }
        }
    }

}