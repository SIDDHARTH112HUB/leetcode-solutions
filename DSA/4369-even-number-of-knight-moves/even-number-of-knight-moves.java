class Pair{
    int row;
    int col;
    int count;
    Pair(int row,int col,int count){
        this.row = row;
        this.col = col;
        this.count = count;
    }
}
class Solution {
    public boolean canReach1(int[] start, int[] target) {
        return (start[0] + start[1]) % 2 == (target[0] + target[1]) % 2;
    }
    public boolean canReach(int[] start, int[] target) {
        int[][] vis = new int[8][8];
        for(int[] row:vis){
            Arrays.fill(row,-1);
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start[0],start[1],0));
        int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dc = {-1,  1, -2,  2, -2, 2, -1, 1};
        while(!q.isEmpty()){
            Pair cur = q.poll();
            int r = cur.row;
            int c = cur.col;
            int count = cur.count;
            if(r==target[0] && c==target[1] && count%2==0){
                return true;
            }
            if(vis[r][c]!=-1) continue;
            vis[r][c] = 1;
            for(int i = 0; i < 8; i++) {
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr>=0 && nr<8 && nc>=0 && nc<8) {
                    q.offer(new Pair(nr,nc,count+1));     
                }
            }
        }
        return false;
    }
}