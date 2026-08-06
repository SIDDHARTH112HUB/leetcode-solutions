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
    public int pairSum(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode t = head;
        int n=0;
        while(t!=null){
            n++;
            st.push(t.val);
            t= t.next;
        }
        t = head;
        int k=0;
        int ans = Integer.MIN_VALUE;
        while(k<n/2){
            ans = Math.max(ans,st.pop()+t.val);
            k++;
            t=t.next;
        }
        return ans;

    }
}