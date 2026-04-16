class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        if(n==1)
        {
            return arr[0];
        }
        int s=0;
        int e=n-1;
        int m=0;
        while(s<=e)
        {
            if(arr[s] <= arr[e])
            {
                return arr[s];
            }
            m = s + (e-s)/2;
            if(arr[m] < arr[(m+1)%n] && arr[m] < arr[(m+n-1)%n])
            {
                return arr[m];
            }
            if(arr[s] <= arr[m])
            {
                s = m+1;
            }
            else if(arr[e] >= arr[m])
            {
                e = m-1;
            }
        }
        return arr[0];
    }
}
