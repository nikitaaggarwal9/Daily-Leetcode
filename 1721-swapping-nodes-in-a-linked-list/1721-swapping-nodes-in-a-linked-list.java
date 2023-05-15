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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode kStart = head, kEnd = head;
        
        // kth node from starting
        while(k-- > 1) 
            kStart = kStart.next;
        
        ListNode temp = kStart;
        
        // kth node from last
        while(temp.next != null) {
            temp = temp.next;
            kEnd = kEnd.next;
        }
        
        // System.out.println(kStart.val + " " + kEnd.val);
        
        // swap
        int num = kStart.val;
        kStart.val = kEnd.val;
        kEnd.val = num;
        
        return head;
    }
}