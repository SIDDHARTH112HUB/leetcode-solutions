class Solution {
    public int minMaxDifference(int num) {
        List<Integer> nums = new ArrayList<>();
        while(num>0){
            nums.add(0,num%10);
            num = num/10;
        }
        int a =0;
        int b =0;
        int zero = nums.get(0);
        int max=9;
        for(int i:nums){
            if(i!=9){
                max = i;
                break;
            }
        }
        for(int i:nums){
            int c = i==zero?0:i;
            a=a*10+c;

            c = i==max?9:i;
            b=b*10+c;
        }
        return b - a;
    }
}