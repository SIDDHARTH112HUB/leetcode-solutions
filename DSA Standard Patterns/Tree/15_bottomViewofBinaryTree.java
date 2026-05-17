/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/
import java.util.*; 
class Solution {
    class Pair{
        int key;
        Node node;
        public Pair(int k, Node n){
            key= k;
            node = n;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        if(root==null)
        return ans; 

        q.add(new Pair(0,root));
        int level =0;
        while(!q.isEmpty()){
            int n = q.size();
            while(n-->0){
                Pair t = q.poll();
                int x = t.key;
                mp.compute(x, (k, v) -> t.node.data);
                if(t.node.left!=null){
                    q.add(new Pair(x-1,t.node.left));
                }                
                if(t.node.right!=null){
                    q.add(new Pair(x+1,t.node.right));
                }
            }
        }
        for(int a : mp.values()){
            ans.add(a);
        }
        return ans;
        
    }
}