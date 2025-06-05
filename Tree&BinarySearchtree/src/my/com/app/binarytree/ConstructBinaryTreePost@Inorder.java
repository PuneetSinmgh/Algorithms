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
    
    HashMap<Integer, Integer> hm = new HashMap();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if ( inorder.length ==1)
            return new TreeNode(inorder[0]);
        
        for ( int i =0 ; i<inorder.length; i++){
            hm.put(inorder[i], i);
        }
     return  getNode( inorder, postorder, 0, inorder.length - 1, 0, postorder.length -1 );
    }
    
    public TreeNode getNode(int[] inorder, int[] postorder , int inSt, int inEd, int postSt, int postEd  ) {
        // end case when leaf node doesn't have any 
        if ( inSt == inEd){
            return new TreeNode(inorder[inSt]);
        }
        
        TreeNode root = new TreeNode(postorder[postEd]);
        int idx  = hm.get(root.val);
        
        int leftSubLen = idx - inSt;
        int rightSubLen = inEd - idx;
        
        if (leftSubLen == 0){
          root.left = null; 
        } else {
            root.left = getNode(inorder, postorder, inSt, idx-1, postSt, postSt+leftSubLen -1 );   
        }
        
        if (rightSubLen == 0) {
            root.right = null; 
        } else {
            root.right = getNode(inorder, postorder, idx+1 , inEd , postEd - rightSubLen , postEd-1 );
        }
        
        return root;
    }
    
}