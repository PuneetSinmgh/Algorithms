package my.com.app.binarytree;

import java.util.LinkedList;
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

 // approach 1 : using BFS
 // we can use a queue to traverse the tree level by level
 // and check if we encounter a null node before all nodes are processed at that level.

import java.util.*;
 
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return false;
        
        if (root.left == null && root.right == null)
            return true;

        Queue<TreeNode> que = new LinkedList();
        que.add(root);

        boolean nullFound = false;
        while(!que.isEmpty()){
            
            int n = que.size();
            for ( int i=0 ; i <n; i++){
                TreeNode node = que.poll();

                if ( !nullFound && node == null)
                    nullFound = true;
                
                if ( nullFound && node != null )
                    return false;
                 
                if ( node != null){
                    que.add( node.left);
                    que.add( node.right);
                }
            }
        }

        return true;
    }
}

/*
 * class Solution {
    int countNodes(TreeNode root) {
        if(root==null) return 0;
        return 1+countNodes(root.left) + countNodes(root.right);
    }
    public boolean isCompleteTree(TreeNode root) {
        int index= 0 ;
        int total = countNodes(root);
        return isCBT(root,index,total);
    }
    boolean isCBT(TreeNode root, int index, int total) {
        if(root == null) return true;
        if(index>=total) return false;
        else {
            boolean left = isCBT(root.left,2*index+1,total);
            boolean right = isCBT(root.right,2*index+2,total);
            return left && right;
        }
    }
}
 * 
*/