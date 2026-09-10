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
    public ListNode reverseBetween(ListNode head, int left, int right) { 

       if( head == null) return null;
       if( left == right) return head;

       ListNode t = head;
       ListNode before = null;
       int pos = 1;

       while(t != null){  // move t to the left position
        if(pos < left){
            before = t;
            t = t.next;
            pos++;
            continue;
        }
        break;
       } 

       ListNode curr = t;  // t == left
       ListNode prev = null;
       int times = right-left+1;

       while(times --> 0){       //reverse req. portion

        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;

       }

       t.next = curr;   //Connect the reversed portion to the remaining list
       if(before != null){       
        before.next = prev;
        return head;
       }
       return prev;
    }
}