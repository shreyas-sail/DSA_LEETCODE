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
    public ListNode swapPairs(ListNode head) {
        if (head ==  null || head.next == null) return head;
        ListNode newHead = head.next;
        ListNode newNext = newHead.next;
        newHead.next = head;
        head.next = swapPairs(newNext);
        return newHead;
    }
    
   
}