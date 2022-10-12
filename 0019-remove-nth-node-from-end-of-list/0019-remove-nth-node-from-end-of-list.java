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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode cur = dummy;
        while(n>0){
            cur = cur.next;
            n--;
        }
        while(cur.next != null){
            slow = slow.next;
            cur = cur.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
        
    }
}