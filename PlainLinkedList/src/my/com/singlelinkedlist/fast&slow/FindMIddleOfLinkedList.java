package my.com.singlelinkedlist.fast_slow;

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
    public ListNode middleNode(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
      /*  
        int num =0 ;
        ListNode cur = head;
        while(cur!=null){
            num++;
            cur = cur.next;
        }
        
        num = num/2 ;
        
        cur = head;
        while(num>0){
            num--;
            cur = cur.next;
        }*/
        ListNode n1 = head;
        //ListNode n2 = head;

        while ( head != null && head.next != null) {
            head = head.next.next;
            n1 = n1.next;
        }
        
        return n1;
    }
}