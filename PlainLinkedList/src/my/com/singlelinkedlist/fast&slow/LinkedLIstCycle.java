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
public class Solution {
    public boolean hasCycle(ListNode head) {
     if(head==null)
        return false;
     if(head.next == null)
        return false;
        
        ListNode l1= head , l2=head.next ;
        
        while(l1!=l2){
            
            if(l1!=null && l2!=null && l2.next!=null){
                l1 = l1.next;
                l2 = l2.next.next;
            }
            else
                return false;
        }
        
        if(l1 == l2)
            return true;
        
    return false;
    }
}

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
public class DetectCycle2 {
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