package my.com.singlelinkedlist.twopointers;

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

    /*
    recursive algo : Use temp/ prev pointer to track new list , move curr and next pointer to set 
    curr.next points to prev . then c=move curr to next and next to curr.next
    */
    
    public ListNode reverseList(ListNode head) {
        
        /*
        if(head == null || head.next == null )
            return head;
        
        Stack<ListNode> st = new Stack();
        ListNode var = head;
        while(var!=null){
            st.push(var);
            var = var.next;
        }
        
        head = st.peek();
        ListNode newNode = null;
        var = head;
        while(!st.isEmpty()){
            
            newNode = st.pop();
            
            if(newNode.next != null)
                var.next= newNode;
            
            var = newNode;
            var.next = null;
        }
        
        return head; */
        
        /*
        if(head == null || head.next == null )
            return head;
        
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;
        
        while(next!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev; */
        
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;
        
        return reverse(prev , cur , next);
    }
    
    public ListNode reverse(ListNode prev , ListNode cur, ListNode next){
        if(next== null)
            return prev;
        
        next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
        return reverse(prev , cur , next);
    }
    
}