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
    public void reorderList(ListNode head) {
        ListNode fast=head, slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow;
        slow = reverseList(slow.next);
        temp.next=null;

        while(head!=null && slow!=null){
            temp = head.next;
            head.next=slow;
            slow=slow.next;
            head=head.next;
            head.next =temp;
            head=temp; 
        }
        
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev =null;

        while(head!=null){
            ListNode temp = head.next;
            head.next = prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
}