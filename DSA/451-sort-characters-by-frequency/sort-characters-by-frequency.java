class Pair{
        int key;
        char c;
        public Pair(int k, char ch){
            key= k;
            c = ch;
        }
    }
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        for(char c:s.toCharArray()){
            mp.merge(c,1,Integer::sum);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.key, a.key));
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            pq.add(new Pair(entry.getValue(),entry.getKey()));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int i=0;
            while(i<p.key){
                sb.append(p.c);
                i++;
            }
        }
        return sb.toString();
    }
}