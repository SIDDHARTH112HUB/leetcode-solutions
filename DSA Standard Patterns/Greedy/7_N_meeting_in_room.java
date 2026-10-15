class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        // code here
        int [][] meet = new int [s.length][3];
        for(int i=0;i<s.length;i++){
            meet[i][0] = s[i];
            meet[i][1] = f[i];
            meet[i][2] = i+1;
        }
        
        Arrays.sort(meet,(a,b) ->Integer.compare(a[1],b[1]));
        
        int cnt=1;
        int freeTime = meet[0][1];
        ArrayList<Integer> ans= new ArrayList<>();
        ans.add(meet[0][2]);
        for(int i=1;i<meet.length;i++){
            if(meet[i][0]>freeTime){
                cnt++;
                ans.add(meet[i][2]);
                freeTime = meet[i][1];
            }
        }
        ans.sort(Comparator.naturalOrder());
        return ans;
    }
}