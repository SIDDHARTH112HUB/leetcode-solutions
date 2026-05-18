public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList <Integer> ans = new ArrayList<>();
        if(A==null) return ans;
        getPath(A,ans, B);
        
        return ans;
    }
    public boolean getPath(TreeNode root,ArrayList <Integer> arr, int B){
        if(root==null)
        return false;
        
        arr.add(root.val);
        if(root.val==B)
        return true;
        
        if(getPath(root.left,arr,B)||getPath(root.right,arr,B))
        return true;
        
        arr.remove(arr.size()-1);
        return false;
    }
}