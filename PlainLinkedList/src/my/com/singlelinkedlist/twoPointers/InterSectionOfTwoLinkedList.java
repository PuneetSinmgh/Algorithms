package my.com.singlelinkedlist.twopointers;

impoert java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode c1 = headA;
        ListNode c2 = headB;

        // find length of the lists
        int lenA = 0;
        while(c1 != null){
            c1 = c1.next;
            lenA++;
        }
        
        int lenB = 0;
        while(c2 != null){
            c2 = c2.next;
            lenB++;
        }
        
        c1 = headA;
        c2 = headB;
        // move the pointer on longer head the diff
        if ( lenA < lenB){
            
            for ( int i=0 ; i < lenB-lenA; i++){
                c2 = c2.next;        
            }
        } else {

            for ( int i=0 ; i < lenA-lenB; i++){
                c1 = c1.next;        
            }
        }
        
        // now both pointer are equal lenght from the end 
        while(c1 != c2){
            c1 = c1.next;
            c2 = c2.next;
        }
        
        return c1;
    }
    
}