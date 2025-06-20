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
    public void reorderList(ListNode head) {   
        /* traverse upto middle and change the start pointer to point middle pointer continue untill the end of the lined list. Sol using extra space
        ListNode mid = head, end = head , newList;
        while( end != null && end.next != null) {   
            mid = mid.next;
            end = end.next.next;
        }
        end  = mid;
        Stack<ListNode> st = new Stack();  
        while(mid !=null){
            st.push(mid);
            mid = mid.next;
        }
        end.next = null;
        ListNode n, alt, curr = head;
        while (!st.isEmpty()){
            n = curr.next;
            alt = st.pop();

            curr.next = alt;
            if (alt != n){
                alt.next = n;
                curr = n;
            }    
        }
        */

        // Without using extra space
        // Find middle of the list and reverse the second half of the list.
        ListNode mid = head, end = head , newList;
        while( end != null && end.next != null) {   
            mid = mid.next;
            end = end.next.next;
        }
        end  = mid;

        ListNode head2 = reverse( end.next); // reverse the remaining half of list.
        end.next = null;
        
        // Now we have two lists, head1 and head2, we will merge them in the required order.
        ListNode head1 = head, temp = head;
        boolean flag = true;
        while(head2!=null && head1!=null){
            if (flag){
                temp = head1.next;
                head1.next = head2;
                head1 = temp;
                flag = false;
            } else {
                temp = head2.next;
                head2.next = head1;
                head2 = temp;
                flag = true;
            }
        }
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null , curr = head, temp;
        while ( curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev; 
    } 
}