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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        int len=0, offset;
        ListNode l1=head, l2, l3;
        while(l1!=null){
            len++;
            l1 = l1.next;
        }
        
        // length can be longer than /shorter/ equal to the length of the list
        if(len>k){
            offset = len-k;    
        }else if(k>len){
            offset = len - (k%len);
        }else{
            return head;
        }
        
        l2= head;
        while(offset!=0){
           l1 = l2;
            l2=l2.next;
            offset--;
        } 
        if(l2!=null){
            l3 =l2;    
        }else{
            return head;
        }
        
        while(l3.next!=null){
            l3 = l3.next;
        }
        
        l1.next = null;
        l3.next = head;
        head = l2 ;
        
        return head;
    }
}