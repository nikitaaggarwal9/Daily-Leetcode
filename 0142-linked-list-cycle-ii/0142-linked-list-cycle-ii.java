/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode temp = hasCycle(head);
        if(temp == null) return null;

        ListNode start = head;
        while(start != temp) {
            start = start.next;
            temp = temp.next;
        }

        return start;
    }

    public ListNode hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return slow;
        }
        return null;
    }
}