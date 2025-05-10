package my.com.app;

import java.util.*;

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

// Reverse a linked list in pairs
// Recursively create a new list and set the next of the first node to the result of the next pair
// set the next of the second node to the first node
// return the second node as result

class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if (head == null)
            return null;
        
        if ( head.next == null)
            return head;
        
        ListNode temp = head.next;
        
        head.next = swapPairs( head.next.next);
        
        temp.next = head;
        
        return temp;
        
    }
}