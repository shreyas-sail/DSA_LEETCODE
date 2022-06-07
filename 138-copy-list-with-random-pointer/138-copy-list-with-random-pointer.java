/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null ) return head;
      createCloneNodes(head);
        Node temp = head;
       while(temp.next != null){
           System.out.println(temp.val);
           temp = temp.next;
       }
      populateRandomPointers(head);
      return populateNextPointers(head); 
        //return head;
    }
    void createCloneNodes(Node head){
        Node iter = head;
        while(iter != null ){
            Node newNext = iter.next;
            iter.next = new Node(iter.val);
            iter.next.next = newNext;
            iter = newNext;
        }
    }
    
    void populateRandomPointers(Node head){
        Node iter = head;
        while(iter != null ){
            if(iter.random != null)
                iter.next.random = iter.random.next;
            else
                iter.next.random = null;
            iter = iter.next.next;
        }
    }
    
    Node populateNextPointers(Node head){
        Node iter = head;
        Node dummy = new Node(0);
        Node ans = dummy;
        // Node front = iter.next.next == null?null:iter.next.next;
        while(iter!=null){
            Node front = iter.next.next;
            dummy.next = iter.next;
            iter.next = front;
            dummy = dummy.next;
            iter = front;
        }
        return ans.next;
    }
}