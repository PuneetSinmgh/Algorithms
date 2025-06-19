package com.my.singlelinkedlist.fastandslow;

import java.util.*;

public class Solution {
    public int cycleLength(ListNode head) {
        
        if(head==null )
            return null;
        
        ListNode slow = head;
        ListNode fast = head;   
        while(slow != null && fast!=null &&  fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                // Cycle detected, now find the length of the cycle
                int length = 1;
                ListNode current = slow;
                while(current.next != slow) {
                    current = current.next;
                    length++;   
                }
                return length;
            }

        }
            return 0; // No cycle found
    }   
}
