class Solution {
    public boolean scoreBalance(String s) {
        int total =0;
        for(char c :s.toCharArray()){
            total+=c-'a'+1;
        }
        if(total%2==1)
        return false;

        int sum =0;
        for(char c :s.toCharArray()){
            sum+=c-'a'+1;
            if(sum==total/2)
            return true;

            if(sum>total/2)
            return false;
        }
        return false;
    }
}