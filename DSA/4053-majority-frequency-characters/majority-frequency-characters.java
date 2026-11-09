class Solution {
    public String majorityFrequencyGroup(String s) {
        int [] ch = new  int [26];
        for(char c:s.toCharArray()){
            ch[c-'a']++;
            
        }
        int []f = new int [101];
        int max = 0;
        int cn=0;
        for (int i:ch){
            if(i!=0){
                f[i]++;
                if (f[i] > max || (f[i] == max && i > cn)){
                    cn = i;
                    max = f[i];
                }
                //System.out.println(f[i]);
            }
        }
        System.out.println(cn);
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<26;i++){
            if(ch[i]==cn){
                char t = (char) ('a' + i);
                sb.append(t);
            }
        }
        return sb.toString();
    }
}