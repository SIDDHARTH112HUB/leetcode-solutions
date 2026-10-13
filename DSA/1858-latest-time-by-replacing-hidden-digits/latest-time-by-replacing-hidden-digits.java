class Solution {
    public String maximumTime(String time) {
        int []m = new int[] {2,4,5,9};
        char [] ch = new char[5];
        char h1 = time.charAt(0);
        char h2 = time.charAt(1);
        if(h1=='?'){
            if(h2=='?' || h2<='3')
            ch[0]='2';
            else
            ch[0]='1';
        }
        else{
            ch[0]=h1;
        }
        if(h2=='?'){
            if(ch[0]=='2')
            ch[1]='3';
            else
            ch[1]='9';
        }
        else{
            ch[1]=h2;
        }
        ch[2] = ':';
        char m1 = time.charAt(3);
        char m2 = time.charAt(4);
        if(m1=='?'){
            ch[3]='5';
        }
        else{
            ch[3]=m1;
        }
        if(m2=='?'){
            ch[4]='9';
        }
        else{
            ch[4]=m2;
        }
        String str = String.valueOf(ch);
        return str;
    }
}