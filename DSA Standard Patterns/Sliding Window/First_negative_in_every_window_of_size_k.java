import java.util.*;

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        int i=0,j=0;
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> temp = new LinkedList<>();
        while(j<arr.length){
            if(arr[j]<0){
                temp.add(arr[j]);
            }
            if(j-i+1==k){
                ans.add(temp.isEmpty() ? 0 : temp.peek());
                if(arr[i]<0){
                    temp.poll();
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}