/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> st1 = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();
        while(l1!=null){
            st1.push(l1);
            l1 = l1.next;
        }
        while(l2!=null){
            st2.push(l2);
            l2 = l2.next;
        }
        int s =0;
        ListNode node = new ListNode(0);
        while(st1.size()>0 && st2.size()>0){
            s+= st1.pop().val + st2.pop().val;
            ListNode n = new ListNode(s%10);
            s=s/10;
            n.next = node.next;
            node.next = n; 
        }
        while(st2.size()>0){
            s+= st2.pop().val;
            ListNode n = new ListNode(s%10);
            s=s/10;
            n.next = node.next;
            node.next = n; 
        }
        while(st1.size()>0 ){
            s+= st1.pop().val;
            ListNode n = new ListNode(s%10);
            s=s/10;
            n.next = node.next;
            node.next = n; 
        }
        if(s>0){
            ListNode n = new ListNode(s);
            n.next = node.next;
            node.next = n; 
        }
        return node.next;
    }
}