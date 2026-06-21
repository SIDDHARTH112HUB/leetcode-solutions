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
        int r=0;
        ListNode dummy= new ListNode(0);
        ListNode ans=dummy;
        while(l1!=null && l2!=null){
            int a =l1.val;
            int b =l2.val;
            int c = a+b+r;
            r= c/10;
            ListNode t = new ListNode(c%10);
            dummy.next=t;
            dummy=t;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null ){
            int a =l1.val;
            int c = a+r;
            r= c/10;
            ListNode t = new ListNode(c%10);
            dummy.next=t;
            dummy=t;
            l1=l1.next;
            
        }
        while(l2!=null){
            int b =l2.val;
            int c = b+r;
            r= c/10;
            ListNode t = new ListNode(c%10);
            dummy.next=t;
            dummy=t;
            l2=l2.next;
        }
        if(r>0){
            ListNode t = new ListNode(r);
            dummy.next=t;
            dummy=t;
        }
        return ans.next;
    }
}
