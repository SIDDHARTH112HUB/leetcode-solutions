class Solution {
    public List<String> findRepeatedDnaSequences1(String s) {
        Set<String> seen=new HashSet<>();
        Set<String>repeated=new HashSet<>();
        for(int i=0;i<=s.length()-10;i++){
            String cur=s.substring(i,i+10);
            if(seen.contains(cur))repeated.add(cur);
            else seen.add(cur);
        }
        return new ArrayList<>(repeated);
    }
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> set = new HashSet<>();
        int[] map = new int[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        //each charecter is considered as a 2 bit value 00, 01, 10, 11 so instead of storing 80 bit (8 bit per character)
        // we are storing 20 bit( 2 bit per character- 1 32 bit Integer is enough) so complexity wise its same
        // but is little faster as size reduced drastically
        Set<String> tmp = new HashSet<>();

        for(int i = 9; i < s.length(); i++) {
            int mask = 0;
            for(int j = i - 9; j <= i; j++) {
                char c = s.charAt(j);
                mask = mask << 2;
                mask = mask | map[c - 'A'];
                
            }
            if(!set.add(mask)) {
                tmp.add(s.substring(i-9, i + 1));
            }
        }
        return new ArrayList<>(tmp);
    }
}