package src.my.com.app.binarysearchtree;

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head == null )
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        
        return createBST(head,null);
        
    }

    public TreeNode createBST(ListNode start,ListNode end) {
        if(start == null )
            return null;
        if (start == end)
            return new TreeNode(start.val);

        ListNode mid = getMidNode(start, end);
        TreeNode currRoot = new TreeNode(mid.val);
        currRoot.left = createBST(start,mid);
        currRoot.right = createBST(mid.next,end);

        return currRoot;
    }
    public ListNode getMidNode(ListNode start, ListNode end) {
        ListNode slow = start;
        ListNode fast = start;

        while(fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}