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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        int  count = 1;
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        System.out.println(count);
        temp.next = head;
        k = k%count;
        System.out.println(k);
        k = count - k; 
        System.out.println(k);
        temp = head;
        while(k != 1){
            temp = temp.next;
            k--;
        }
        head = temp.next;
        temp.next =null;
        return head;
    }
}