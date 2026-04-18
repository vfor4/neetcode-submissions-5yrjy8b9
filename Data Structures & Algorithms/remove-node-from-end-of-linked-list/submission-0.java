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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        int i = n;
        while(second != null && i-- != 0) {
            second = second.next;
        }

        ListNode pre = null;
        while(second != null) {
            pre = first;
            first = first.next;
            second = second.next;
        }
        if (pre == null) {
            return head.next;
        }

        pre.next = first.next;
        first.next = null;

        return head;
    }
}
