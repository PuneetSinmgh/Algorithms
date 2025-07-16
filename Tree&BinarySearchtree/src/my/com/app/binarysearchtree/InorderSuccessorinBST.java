package my.com.app.binarysearchtree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      
        if(root!=null){
            
            if(root.val<=p.val){
                 return inorderSuccessor(root.right, p);
            }else{
                TreeNode n = inorderSuccessor(root.left, p);
                return n == null? root :  n;
            }
        }
        return null;
    }    
        
    /*  
        // Iterative solution
        // Create a list for Inorder traversal, and loop over the list to find the value , return the next value
        List<TreeNode> l = new ArrayList();
        inorder(root,l);
            
        for(int i=0 ; i<l.size(); i++){
            if(l.get(i).val == p.val && i<l.size()-1){
                return l.get(++i);
            }
        }        
        return null;
    }
    
    public void inorder(TreeNode root ,  List<TreeNode> l){

        if(root!=null){
            
            inorder(root.left, l);
            l.add(root);
            inorder(root.right, l);
        }
      */  
    
    public TreeNode getSuccessor(TreeNode root){
        if(root == null)
            return null;
        else
            root = root.right;
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    
}