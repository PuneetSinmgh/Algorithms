package my.com.app.binarysearchtree;

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

// Approach 1: Inorder Traversal

class Solution {
    public boolean isValidBST(TreeNode root) {
     
       if(root == null)
           return true;
        int pre = getPredecessor(root);
        int scr = getSuccessor(root);
        
        if(root.left==null && root.right== null)
            return true;
        else if(root.left!=null && root.right== null){
            return pre<root.val && isValidBST(root.left);
        }
        else if(root.left==null && root.right!= null){
            return root.val<scr && isValidBST(root.right);
        }
        else{
            return pre<root.val && root.val<scr && isValidBST(root.left) && isValidBST(root.right);
        }
    }
    
    public int getPredecessor(TreeNode root ){
        if(root.left == null)
            return root.val;
        else
            root = root.left;
        while(root.right!=null){
            root = root.right;
        }
        return root.val;
    }
    
    public int getSuccessor(TreeNode root ){
        if(root.right == null)
            return root.val;
        else
            root = root.right;
        while(root.left!=null){
            root = root.left;
        }
        return root.val;
    }
}