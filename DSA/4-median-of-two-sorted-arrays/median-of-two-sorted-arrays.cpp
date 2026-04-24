class Solution {
public:
    double findMedianSortedArrays(vector<int>& a, vector<int>& b) {
        a.insert(a.end(), b.begin(), b.end());
        int n=a.size();
        sort(a.begin(),a.end());
        if (n % 2 != 0)
            return (double)a[n / 2];
 
        return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0;
    }
};