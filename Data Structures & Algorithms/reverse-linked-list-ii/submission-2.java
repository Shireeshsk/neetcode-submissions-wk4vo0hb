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
        ListNode curr = head;
        ListNode prev = null;
        int c = 1;
        while(curr!=null){
            if(c==left) break;
            prev = curr;
            curr = curr.next;
            c++;
        }
        ListNode revh = helper(curr,c,right);
        if(prev==null){
            return revh;
        }
        prev.next = revh;
        return head;
    }
    public ListNode helper(ListNode head,int c,int r){
        if(c==r) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            c++;
            if(c-1==r){
                head.next=curr;
                break;
            }
        }
        return prev;
    }
}