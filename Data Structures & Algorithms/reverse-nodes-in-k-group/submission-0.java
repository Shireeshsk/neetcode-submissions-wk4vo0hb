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
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        ListNode prevgt = null;
        while(true){
            ListNode kthNode = helper(curr,k);
            if(kthNode==null) break;
            ListNode knext = kthNode.next;
            ListNode rh = curr;
            ListNode sk = curr;
            ListNode prev = knext;
            while(prev!=kthNode){
                ListNode temp = sk.next;
                sk.next = prev;
                prev = sk;
                sk=temp;
            }
            if(dummy.next==null){
                dummy.next=prev;
            }
            if(prevgt!=null){
                prevgt.next = prev;
            }
            prevgt = rh;
            curr = knext;
        }
        return dummy.next;
    }

    public ListNode helper(ListNode curr,int k){
        int l = 1;
        while(l!=k && curr!=null){
            curr = curr.next;
            l++;
        }
        return curr;
    }
}
