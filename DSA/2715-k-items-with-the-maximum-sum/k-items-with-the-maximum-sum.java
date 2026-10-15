class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;
        if(k<=numOnes)
        return k;

        sum+= numOnes;
        k-=numOnes;

        if(k<=numZeros)
        return sum;

        k-=numZeros;

        return sum-k;
    }
}