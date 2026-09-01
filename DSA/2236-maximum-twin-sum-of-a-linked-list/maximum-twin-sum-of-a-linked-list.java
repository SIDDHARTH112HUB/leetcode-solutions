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
        int n = 0;
        ListNode current = head;
        while(current!=null){
            n++;
            current = current.next;
        }


        int[] arr = new int[n];
        int i = 0;
        current = head;
        while(current!=null){
            arr[i] = current.val;
            current = current.next;
            i++;
        }

        int maxSum = 0;
        int j=0;
        int k = arr.length-1;

        while(j<k){
            int sum = arr[j] + arr[k];
            maxSum = Math.max(maxSum,sum);
            j++;
            k--;
        }

        return maxSum;

    }
}