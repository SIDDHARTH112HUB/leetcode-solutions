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
