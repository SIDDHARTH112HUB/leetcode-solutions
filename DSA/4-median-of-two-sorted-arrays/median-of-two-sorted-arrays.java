class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int n1=nums1.length;
        int n2 =nums2.length;
        int []f = new int[n1+n2];
        int j=0,k=0;
        while(j<n1 && k<n2){
            if(nums1[j]<nums2[k]){
                f[i]=nums1[j];
                i++;
                j++;
            }
            else{
                f[i]=nums2[k];
                i++;
                k++;
            }
        } 
        while(j<n1){
            f[i]=nums1[j];
                i++;
                j++;
        } 
        while(k<n2){
            
                f[i]=nums2[k];
                i++;
                k++;
        } 
        int n =n1+n2;
        if (n % 2 != 0) {
            // Odd length: middle element
            return f[n / 2];
        } else {
            // Even length: average of two middle elements
            return (f[(n / 2) - 1] + f[n / 2]) / 2.0;
        }
    }
}
