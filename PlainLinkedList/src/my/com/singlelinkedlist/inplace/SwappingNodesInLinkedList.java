package my.com.singlelinkedlist.inplace;

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
    public ListNode swapNodes(ListNode head, int k) {

        ListNode n1=head , n2=head, n3 =head; 
        for (int i=0; i<k ; i++){
            n2 = n1;
            n1 = n1.next;
            
        }
        
        n1 = n2;
        while (n2.next != null){
            n3 = n3.next;
            n2 = n2.next;
        }
        
        int temp = n3.val;
        n3.val = n1.val;
        n1.val = temp; 

        return head;
    }
}