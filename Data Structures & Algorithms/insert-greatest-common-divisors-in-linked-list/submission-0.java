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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode n1 = head;
        ListNode n2 = head.next;
        while(n2!=null){
            int gcd = gcd(n1.val,n2.val);
            n1.next = new ListNode(gcd);
            n1.next.next = n2;
            n1 = n2;
            n2 = n1.next;
        }
        return head;
    }
    private int gcd(int a,int b){
        for(int i = Math.min(a,b);i>=1;i--){
            if(a%i==0 && b%i==0) return i;
        }
        return 1;
    }
}