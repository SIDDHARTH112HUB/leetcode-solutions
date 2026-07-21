class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length==1)
        return true;
        boolean isPart = false;
        boolean start  = false;

        for(int i:bits){
            if(start == true){
                isPart = true;
                start =false;
            }
            else if(i==1){
                start =true;
            }
            else{
                isPart =false;
            }
        }

        return isPart == false;
    }
}