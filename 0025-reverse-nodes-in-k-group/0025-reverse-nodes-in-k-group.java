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

        if (head == null) {
            return head;
        }

        ListNode left = head;
        ListNode prevLeft = null;
        ListNode res = null;

        while (true) {

            // Find the kth node
            ListNode right = left;

            for (int i = 0; i < k - 1; i++) {

                if (right == null) {
                    break;
                }

                right = right.next;
            }

            // Less than k nodes remaining
            if (right == null) {
                break;
            }

            // Save the node after the current group
            ListNode next = right.next;

            // Reverse k nodes
            ListNode curr = left;
            ListNode prev = next;

            for (int i = 0; i < k; i++) {

                ListNode temp = curr.next;

                curr.next = prev;

                prev = curr;
                curr = temp;
            }

            // First reversed group becomes result head
            if (res == null) {
                res = prev;
            }

            // Connect previous group to current reversed group
            if (prevLeft != null) {
                prevLeft.next = prev;
            }

            // left is now the last node of reversed group
            prevLeft = left;

            // Move to next group
            left = next;
        }

        return res;
    }
}