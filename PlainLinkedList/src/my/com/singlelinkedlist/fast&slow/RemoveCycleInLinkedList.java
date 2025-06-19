package com.my.singlelinkedlist.fastandslow;

import java.util.*;

public class Solution {
    public ListNode removeCycle(ListNode head) {
        
        if(head==null )
            return null;
        
        ListNode slow = head;
        ListNode fast = head;

        ListNode prev = head;
        while(slow != null && fast!=null &&  fast.next != null){
            prev = slow
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                // Cycle detected, now remove the cycle
                prev.next = null; // Break the cycle by setting the next of the last node in the cycle to null
                break;
            }
        }
            return head; // No cycle found
    }   
}
