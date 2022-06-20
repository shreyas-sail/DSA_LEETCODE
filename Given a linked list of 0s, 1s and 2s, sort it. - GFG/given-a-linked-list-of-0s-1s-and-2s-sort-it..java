// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node dummy0 = new Node(0);
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node temp0 = null;
        Node temp1 =  null;
        Node temp2 = null;
        while(head != null){
            if(head.data == 0){
                if(temp0 == null){
                    dummy0.next = head;
                    temp0 = dummy0.next;
                }else{
                    //System.out.println(head.data);
                    temp0.next = head;
                    temp0 = temp0.next;
                }
                    
            }else if(head.data == 2){
                if(temp2 == null){
                    dummy2.next = head;
                    temp2 = dummy2.next;
                }else{
                    temp2.next = head;
                    temp2 = temp2.next;
                }
                    
            }else if(head.data == 1){
                if(temp1 == null){
                    dummy1.next = head;
                    temp1 = dummy1.next;
                }else{
                    temp1.next = head;
                    temp1 = temp1.next;
                }
                    
            }
            Node tempN = head.next;
            head.next = null;
            head = tempN;
        }
        if(temp0 != null )
            temp0.next = dummy1.next;
        if(temp1 != null)
            temp1.next = dummy2.next;
        else
            temp0.next = dummy2.next;
        
        return dummy0.next;
    }
}


