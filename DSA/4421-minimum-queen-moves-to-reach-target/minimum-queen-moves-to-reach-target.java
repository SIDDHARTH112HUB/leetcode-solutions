class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        if(source[0]==target[0] && source[1]==target[1] )
        return 0;
        if(source[0]==target[0] || source[1]==target[1] || Math.abs((1f)*(target[1]-source[1])/(target[0]-source[0]))==1)
        return 1;
        
        return 2;
    }
}