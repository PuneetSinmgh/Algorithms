package src.my.com.singlelinkedlist.fastandslow;

import java.util.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 // Detect Cycle in a Linked List II : Find the node where the cycle begins
 //approach : first find the intersection point using fast and slow pointer technique
 // then slow pointer covered distance ( a+b ) and fast pointer covered distance ( a+b+ n*c ) c is the cycle length
 // now distance between head and intersection point is a , whihc is n*c - b , thus we can find the starting point of the cycle by moving slow pointer from head and fast pointer from intersection point
// both will meet at the starting point of the cycle
// Time Complexity : O(n) , Space Complexity : O(1)
//
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head==null )
            return null;
        
        
        ListNode fast = intersect(head);
        if(fast == null)
            return fast;
        
        ListNode slow = head;
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
    
        return slow;
    }
    
    public ListNode intersect(ListNode head){
        
            ListNode slow = head, fast=head;
        int len=0 ;
        while( fast != null && fast.next!=null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow){
                return slow;
            }
        }
        return null;
    }
    
}