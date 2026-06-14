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
        ListNode prev = null;
        ListNode curr = head;
        for(int i = 1;i<left;i++){
            prev = curr;
            curr = curr.next;
        }
        ListNode revh = helper(curr,left,right);
        if(prev==null){
            return revh;
        }
        prev.next = revh;
        return head;
    }

    public ListNode helper(ListNode head,int l,int r){
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = head;
        while(curr!=null){
            ListNode sk = curr.next;
            curr.next = prev;
            prev = curr;
            curr = sk;
            if(l==r){
                temp.next = curr;
                return prev;
            }
            l++;
        }
        return prev;
    }
}