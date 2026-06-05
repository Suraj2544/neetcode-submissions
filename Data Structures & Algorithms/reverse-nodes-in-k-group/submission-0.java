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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;

        // Check if k nodes exist
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If less than k nodes, return as it is
        if (count < k) {
            return head;
        }

        // Reverse first k nodes
        curr = head;
        ListNode prev = null;
        ListNode next = null;

        count = 0;
        while (count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // head becomes the last node after reversal
        head.next = reverseKGroup(curr, k);

        return prev;
    }
}