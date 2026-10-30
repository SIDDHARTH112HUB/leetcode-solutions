class Solution {
    public int minimumDistance(int[] nums) {
        List<List<Integer>> matrix = new ArrayList<>();

        // 2. Initialize the 100 rows with individual ArrayList instances
        for (int i = 0; i <= 100; i++) {
            matrix.add(new ArrayList<>());
        }

        for(int i=0;i<nums.length;i++){
            matrix.get(nums[i]).add(i);
        }
        int ans = Integer.MAX_VALUE;
        boolean found = false;
        for(int i=1;i<=100;i++){
            List<Integer> l = matrix.get(i);
            if(l.size()>=3){
                found =true;
                ans = Math.min(ans,getValue(l));
            }
        }
        if(found==false)
        return -1;
        return ans;

    }
    int getValue(List<Integer> l){
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<l.size();i++){
            for(int j =i+1;j<l.size();j++){
                for(int k =j+1;k<l.size();k++){
                    ans = Math.min(ans, Math.abs(l.get(i)-l.get(k))+Math.abs(l.get(i)-l.get(j))+Math.abs(l.get(k)-l.get(j)) );
                }
            }
        }
        return ans;
    }
}