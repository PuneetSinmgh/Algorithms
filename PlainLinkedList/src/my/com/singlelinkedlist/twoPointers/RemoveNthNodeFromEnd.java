package my.com.singlelinkedlist.twopointers;
import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
     /* Double pass solution
        if(head == null)
            return null;
        
        ListNode p1, p2,p3;
        int i=0;
        p1 =head;
        while(p1!=null){
            i++;
            p1 = p1.next;
        }
        
        if(i==n){
            if(head.next!=null){
                head = head.next;
                return head;
            }
            else{
                head =null;
                return head;
            }
                
        }
        
        int pos = i-n-1;
        p2 = head;
        while( pos>0){
            pos--;
            p2 = p2.next;
            
        }
        
  
            p2.next = p2.next.next;

        
        return head;*/
        
        // single pass solution
        if (n==0)
            return head;
         ListNode p1 = head, p2 = head;
       
        // we need a pointer just before the node to be deleted
        // that can be done by running a two pointer by a gap of n nodes at same speed.
        // Once the fron pointer reaches the end of list, privious pointer reaches the node before the node to remove.

        
        p1 = head ;
        
        for ( int i=0; i< n ; i++ ){    
            p1 = p1.next;
        }
        
        // if pi is null , that mean n is equal to the length of the list
        if ( p1 == null){
            return head.next;
        }
        
        // P1 reaching the last node P2 reaches the node just before the node to be deleted 
        while ( p1.next != null ) {
            p2 = p2.next;
            p1 = p1.next;
        }
            
         p2.next = p2.next.next;
        
        return head;
    }
}