// class Solution {
//     public int earliestFinishTime(int[] lst, int[] ld, int[] wst, int[] wd) {
//         int time=Integer.MAX_VALUE;
//         for(int i=0;i<lst.length;i++){
//             for(int j=0;j<wst.length;j++){
//                 int temp = lst[i]+ld[i];
//                 if(temp>=wst[j]){
//                     temp+=wd[j];
//                 }
//                 else{
//                     // System.out.println(temp);
//                     temp = wst[j]+wd[j];
//                 }
//                 time = Math.min(temp,time);
//             }
            
//         }
//         for(int i=0;i<wst.length;i++){
            
//             for(int j=0;j<lst.length;j++){
//                 int temp = wst[i]+wd[i];
//                 if(temp>=lst[j]){
//                     temp+=ld[j];
//                 }
//                 else{
//                     // System.out.println(temp);
//                     temp = lst[j]+ld[j];
//                 }
//                 time = Math.min(temp,time);
//             }
//         }
//         return time;
//     }
// }

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) 
    {
        int ans=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++)
        {
            min=Math.min(min,landStartTime[i]+landDuration[i]);
        }
        for(int i=0;i<waterStartTime.length;i++)
        {
            ans=Math.min(ans,Math.max(min,waterStartTime[i])+waterDuration[i]);
        }
        min=Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++)
        {
            min=Math.min(min,waterStartTime[i]+waterDuration[i]);
        }
        for(int i=0;i<landStartTime.length;i++)
        {
            ans=Math.min(ans,landDuration[i]+Math.max(min,landStartTime[i]));
        }
        return ans;
    }
}