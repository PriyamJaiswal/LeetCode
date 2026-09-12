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

        if( head == null) return head;
        ListNode left = head;
        ListNode right;
        ListNode res = null;
        ListNode prevLeft = null;

        while(true){

            right = left;        // Find the kth node
            for(int i=0; i<(k-1); i++){
                if(right == null) break; // Less than k nodes remaining
                right=right.next;

            } 
            if(right != null){
                ListNode nextLeft = right.next;   // Save the node after the current group
                reverse(left,k);                  //call reverse function
                
                if(prevLeft != null) prevLeft.next = right;
                prevLeft = left;
                left = nextLeft;
                if(res == null) res = right;   
            } else {
                if(prevLeft != null) prevLeft.next = left;
                if(res == null) res = left;
                break;
            }
        }
        return res;
    }

    public void reverse(ListNode head, int times){
        ListNode curr = head;
        ListNode prev = null;
        while(times --> 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}