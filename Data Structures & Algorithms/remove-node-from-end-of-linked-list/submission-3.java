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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        int c = length(head);
        if(n==c) return head.next;
        int target = c-n;
        ListNode curr = head;
        for(int i = 1;i<target;i++){
            curr = curr.next;
        }
        curr.next=curr.next.next;        
        return head;
    }

    public int length(ListNode temp){
        if(temp==null) return 0;
        int c = 1;
        while(temp.next!=null){
            temp = temp.next;
            c++;
        }
        return c;
    }
}
