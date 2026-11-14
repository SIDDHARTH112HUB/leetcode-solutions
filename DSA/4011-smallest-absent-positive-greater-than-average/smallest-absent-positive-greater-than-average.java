class Solution {
    public int smallestAbsent(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        sum = sum/nums.length;
        sum++;
        sum = Math.max(sum,1);
        System.out.println(sum);
        for(int i:nums){
            if(i<sum)
            continue;

            if(i==sum){
                sum++;
            }
            else{
                return sum;
            }
        //System.out.println(sum);
        }
        return sum;
    }
}