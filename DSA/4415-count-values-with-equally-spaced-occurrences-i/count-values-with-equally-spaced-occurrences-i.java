class Solution {
    public int countSpecialIntegers1(int[] nums) {
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
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i =0;i<n;i++){
            map.putIfAbsent(nums[i],new ArrayList<Integer>());
            map.get(nums[i]).add(i);
        }
        int cnt =0;

        for(int key:map.keySet()){
            List<Integer> temp = map.get(key);
            if(temp.size()!= 3) continue;
            if(temp.get(1)-temp.get(0) == temp.get(2)-temp.get(1)) cnt++;

        }
        return cnt;
    }
}