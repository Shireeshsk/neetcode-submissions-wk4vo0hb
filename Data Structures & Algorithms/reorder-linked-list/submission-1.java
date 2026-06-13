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
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode res = head;
        ListNode l2 = reverse(slow.next);
        slow.next = null;
        ListNode curr = head;
        while(l2!=null){
            ListNode l1n = curr.next;
            ListNode l2n = l2.next;
            curr.next = l2;
            l2.next = l1n;
            curr = l1n;
            l2 = l2n;
        }
        head = res;
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
