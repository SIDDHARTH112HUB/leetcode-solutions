class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans=0;
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i=0;i<points.length-2;i++){
            for(int j=i+1;j<points.length-1;j++){
                for(int k = j+1;k<points.length;k++){
                    //System.out.println(i+ " "+j+ " "+k+ " ");
                    ans = Math.max(ans,calculateArea(points[i][0],points[i][1],points[j][0],points[j][1],points[k][0],points[k][1]));
                }
            }
        }
        return ans;
    }
    public  double calculateArea(double x1, double y1,
                                       double x2, double y2,
                                       double x3, double y3) {
        double area = Math.abs(
                x1 * (y2 - y3) +
                x2 * (y3 - y1) +
                x3 * (y1 - y2)
        ) / 2.0;
        return area;
    }
}