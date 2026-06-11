/*
Definition for Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {
    public int inOrderSuccessor(Node root, Node k) {
        int ans = Integer.MAX_VALUE;
        while(true && root!=null){
            if(root.data<=k.data)
            {
                root=root.right;
            }
            else{
                ans = Math.min(ans,root.data);
                root=root.left;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
}