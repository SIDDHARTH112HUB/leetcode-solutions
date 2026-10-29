class Solution {
    public int minimumFlips(int n) {
        List<Integer> a = new ArrayList();
        while(n>0){
            a.add(0,n%2);
            n=n>>1;
        }
        int ans =0;
        int i=0;
        int j = a.size()-1;
        while(i<j){
            System.out.print(a.get(i));
            System.out.println(a.get(j));
            if(a.get(i)!=a.get(j)){
                ans+=2;
            }
            i++;
            j--;
        }
        return ans;
    }
}