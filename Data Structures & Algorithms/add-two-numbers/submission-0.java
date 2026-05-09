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
                var result = new ListNode();
        var first = result;
        int carry = 0;
        while(l1 != null || l2 != null) {
            var val1 = l1 != null ? l1.val : 0;
            var val2 = l2 != null ? l2.val : 0;

            var val = val1 + val2 + carry;
            var sum = val % 10;
            carry = val / 10;

            result.next = new ListNode(sum);
            result = result.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            result.next = new ListNode(carry);
        }
        return first.next;
    }
}
