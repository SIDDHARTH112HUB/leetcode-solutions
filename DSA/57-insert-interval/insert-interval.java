import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] in, int[] ni) {
        if (in.length == 0)
            return new int[][]{ni};
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        for (i = 0; i < in.length; i++) {
            if (in[i][1] >= ni[0]) {
                break;
            }
            ans.add(in[i]);
        }
        if (i == in.length || in[i][0] > ni[1]) {
            ans.add(ni);
        } else {
            int min = Math.min(in[i][0], ni[0]);
            int max = ni[1];
            while (i < in.length && ni[1] >= in[i][0]) {
                i++;
            }
            i--;
            if (i < in.length) {
                max = Math.max(max, in[i][1]);
            }
            ans.add(new int[]{min, max});
            i++;
        }
        while (i < in.length) {
            ans.add(in[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}