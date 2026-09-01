class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            q.offer(i);
        } 
        int j =0;
        int []ans= new int[n];
        while(!q.isEmpty()){
            int i = q.poll();
            ans[i] = deck[j];
            j++;
            if(!q.isEmpty()){
            i = q.poll();
            q.offer(i);
            }
        }
        return ans;
    }
}