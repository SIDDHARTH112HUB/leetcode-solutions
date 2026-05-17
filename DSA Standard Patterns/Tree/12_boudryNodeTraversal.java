/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    private boolean isLeaf(Node node){
        return node.left==null && node.right==null;
    }
    void leftBoundaryTraversal(Node root,ArrayList<Integer> res) {
        // code here
        Node t= root.left;
        while(t!=null){
            if(isLeaf(t)==false) res.add(t.data);
            if(t.left!=null){
                t=t.left;
            }
            else
            t=t.right;
        }
    }
    void rightBoundaryTraversal(Node root,ArrayList<Integer> res) {
        // code here
        Node t= root.right;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while(t!=null){
            if(isLeaf(t)==false) temp.add(t.data);
            if(t.right!=null){
                t=t.right;
            }
            else
            t=t.left;
        }
        Collections.reverse(temp);
        res.addAll(temp);
    }
    void leafNodeInOrderTraversal(Node root,ArrayList<Integer> res) {
        // code here
        if(root==null)
        return;
        if(isLeaf(root)==true) res.add(root.data);
        leafNodeInOrderTraversal(root.left,res);
        leafNodeInOrderTraversal(root.right,res);
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> ans =new ArrayList<Integer>();
        
        if(root!=null && !isLeaf(root))
        ans.add(root.data);
        leftBoundaryTraversal(root,ans);
        leafNodeInOrderTraversal(root,ans);
        rightBoundaryTraversal(root,ans);
        return ans;
    }
}
