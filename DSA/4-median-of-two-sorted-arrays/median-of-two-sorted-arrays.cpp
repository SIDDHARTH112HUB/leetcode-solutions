class Solution {
public:
    double findMedianSortedArrays(vector<int>& A, vector<int>& B) {
        if(A.size()>B.size()){
            return findMedianSortedArrays(B,A);
        }
        int x = A.size();
        int y = B.size();
        int start=0;
        double res = -1;
        int end = x;
        while(start<=end){
            int px = start+(end-start)/2;
            int py = (x+y+1)/2-px;
            int maxxleft = (px==0)?INT_MIN:A[px-1];
            int minxright = (px==x)?INT_MAX:A[px];
            int maxyleft = (py==0)?INT_MIN:B[py-1];
            int minyright = (py==y)?INT_MAX:B[py];
            if(maxxleft<=minyright&&maxyleft<=minxright){
                if((x+y)%2==0){
                    int temp = (max(maxxleft,maxyleft)+min(minyright,minxright));
                    double ans = double(temp/2.0);
                    return ans;
                }
                else{
                    return res=double(max(maxxleft,maxyleft));
                }
            }
            else if(maxxleft>minyright){
            end = px-1;
            }
            else{
                start = px+1;
            }
        }
        return res;
    }
};