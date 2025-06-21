package src.my.com.singlelinkedlist.inplace;
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
class Solution {
    public ListNode partition(ListNode head, int x) {
        /*
        ListNode before_head = new ListNode();
        ListNode before = before_head;

        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while(head!=null ){
            
           if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            head = head.next;

            after.next = null;
            before.next = after_head.next;
        }

        return before_head.next;
        */
        
        
        ListNode before_head = new ListNode();
        ListNode before = before_head;

        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while(head!=null ){
            
           if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            head = head.next;

            after.next = null;
            before.next = after_head.next;
        }

        return before_head.next;

    }
}