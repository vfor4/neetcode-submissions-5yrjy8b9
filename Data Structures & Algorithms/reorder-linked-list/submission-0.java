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
        
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var mid = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(mid != null) {
            var temp = mid.next;
            mid.next = prev;
            prev = mid;
            mid = temp;
        }

        var first = head;
        var second = prev;

        while(second != null) {
            var fNext = first.next;
            var sNext = second.next;
            first.next = second;
            second.next = fNext;
            first = fNext;
            second = sNext;
        }

    }
}
