class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> list = mp.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            mp.put(nums[i],list);
        } 
        int ans =0;

        for(List<Integer> l: mp.values()){
            if(l.size()==3){
                int d = l.get(1)-l.get(0);
                boolean t = true;
                //System.out.print(d);
                //System.out.print(" -d  ");
                for(int i=1;i<l.size();i++){
                //System.out.print(l.get(i)+" "+l.get(i-1)+" ");
                    if(l.get(i)-l.get(i-1) != d)
                    t = false;
                }
                //System.out.println("");
                if(t== true)
                ans++;
            }
        }
        return ans;

    }
}