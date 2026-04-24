class Solution {
    public int search(int[] nums, int target) {
        int index = findMin(nums);
        int ans1 = search(nums,target, 0,index);
        int ans2 = search(nums, target, index, nums.length-1);
        return ans1!=-1?ans1:ans2;
    }
    public int findMin(int[] a) {
        int n = a.length;
        int start = 0;
        int end = n-1;
        if(a[start]<=a[end])
        return start;

        while(start <=end){
            int mid = start + (end-start)/2;

            if(a[start]<=a[end])
            return start;
            int next = (mid+1)%n;
            int prev = (mid+n-1)%n;
            if(a[mid]<a[next] && a[mid]<a[prev])
                return mid;
            else if(a[start]<=a[mid])
                start=mid+1;
            else if(a[end]>=a[mid])
                end=mid-1;

        }
        return 0;
    }
    public int search(int[] nums, int target,int start, int end) {
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target)
            return mid;
            else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;

    }
    
}
