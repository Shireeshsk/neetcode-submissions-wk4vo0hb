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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        for(ListNode temp : lists){
            while(temp!=null){
                pq.add(temp);
                temp = temp.next;
            }
        }
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(!pq.isEmpty()){
            curr.next = pq.remove();
            curr = curr.next;
        }
        return head.next;
    }
}
