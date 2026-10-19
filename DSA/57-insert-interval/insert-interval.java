class Solution {
    public int[][] insert(int[][] in, int[] ni) {
        if(in.length==0)
        return new int[][]{ni};
        ArrayList<Integer[]> ans = new ArrayList<>();
        int i=0;
        for(i=0;i<in.length;i++){
            if(in[i][1]>=ni[0]){
                break;
            }
            ans.add(new Integer[]{in[i][0],in[i][1]});
        }
        if(i == in.length || in[i][0] > ni[1]){
            ans.add(new Integer[]{ni[0],ni[1]});
        }
        else{
            int min = Math.min(in[i][0],ni[0]);
            int max = ni[1];
            while(i<in.length && ni[1]>=in[i][0] ){
                i++;
            }
            i--;
            if(i<in.length){
                max = Math.max(max, in[i][1]);
            }
            ans.add(new Integer[]{min,max});
            i++;

        }
        while(i<in.length){
            ans.add(new Integer[]{in[i][0],in[i][1]});
            i++;
        }
        int [][]a = new int[ans.size()][2];
        for(i=0;i<a.length;i++){
            Integer [] b = ans.get(i);
            a[i][0]= b[0];
            a[i][1]= b[1];
        }
        return a;
    }
}