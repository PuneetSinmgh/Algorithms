package src.my.com.app;

import java.util.*;

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
    HashMap<Integer , Integer> lookup = new HashMap();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0 || preorder.length !=inorder.length)
            return null;
        
        for(int i=0 ; i<inorder.length;i++){
            lookup.put(inorder[i],i);
        }
        
        return getNode(inorder,preorder,0,inorder.length-1, 0, preorder.length-1);
        
    }
    
    public TreeNode getNode(int[] inorder,int[] preorder, int start, int end, int prestart, int preend){
        
        if(start == end)
            return new TreeNode(inorder[start]);
        
        TreeNode node = new TreeNode(preorder[prestart]);
        int idx = lookup.get(node.val);
        
        int leftsublen = idx - start;
        if(leftsublen == 0){
            node.left = null;
        }else
            node.left = getNode(inorder,preorder,start,idx-1,prestart+1 ,prestart + leftsublen );
        
        int rightsublen = end - idx; 
        if(rightsublen ==0)
            node.right=null;
        else
            node.right = getNode(inorder,preorder,idx+1,end, prestart + leftsublen+1, preend);
    
        return node;
    }
    
}