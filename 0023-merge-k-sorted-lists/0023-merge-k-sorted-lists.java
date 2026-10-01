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

    class Node{
        int value;
        int row;
        int col;

        Node(int v, int r, int c) {
            value = v;
            row = r;
            col = c;
        }
    }

    class Compare implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.value - b.value;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        
       List<Integer> res = new ArrayList<>();
        int n = lists.length;

        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());

        for (int i = 0; i < n; i++) {         // First element of every linked list

            if (lists[i] != null)  pq.offer(new Node(lists[i].val, i, 0));
        }
        while (!pq.isEmpty()) {

            Node node = pq.poll();
            res.add(node.value);

            int row = node.row;
            int col = node.col;
            ListNode curr = lists[row];

            for (int j = 0; j < col; j++) curr = curr.next;     // Move to next node

            if (curr.next != null) {
                pq.offer( new Node(curr.next.val, row, col + 1));
            }
        }

        ListNode dummy = new ListNode(0);   // Convert result into Linked List
        ListNode temp = dummy;

        for (int value : res) {
            temp.next = new ListNode(value);
            temp = temp.next;
          }
        return dummy.next;
    }
  
}