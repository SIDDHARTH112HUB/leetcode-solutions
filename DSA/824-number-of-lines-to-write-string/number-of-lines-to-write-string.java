class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int line =0;
        int temp=0;
        int last=0;
        for(char c:s.toCharArray()){
            int a = widths[c-'a'];
            if(a+temp<=100){
                temp+=a;
                last+=a;
            }
            else{
                temp =a;
                last =a;
                line++;

                // System.out.print(temp+" temp, ");
                // System.out.print(last+" last, ");
                // System.out.print(a+" a, ");
                // System.out.print(line+" line, ");
                // System.out.println(c+" C ");
            }
        }
        line++;
        return new int[]{line,last};
    }
}