M1 -  O (m+n) time and O(m+n) space
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


M2 -  O (m+n) time and O(1) space

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int total = n1 + n2;
        int mid1 = (total - 1) / 2, mid2 = total / 2;

        int i = 0, j = 0, count = 0;
        int val1 = 0, val2 = 0;

        while (count <= mid2) {
            int val;
            if (i < n1 && (j >= n2 || nums1[i] <= nums2[j])) {
                val = nums1[i++];
            } else {
                val = nums2[j++];
            }

            if (count == mid1) val1 = val;
            if (count == mid2) val2 = val;
            count++;
        }

        return (val1 + val2) / 2.0;
    }
}

M3 - O(log(min(m,n))) time and O(1) space


class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) return findMedianSortedArrays(B, A);

        int m = A.length, n = B.length;
        int low = 0, high = m;

        while (low <= high) {
            int partitionA = (low + high) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : A[partitionA - 1];
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : A[partitionA];

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : B[partitionB - 1];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : B[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = partitionA - 1;
            } else {
                low = partitionA + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
