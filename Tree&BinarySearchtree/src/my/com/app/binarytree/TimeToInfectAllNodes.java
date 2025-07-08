package my.com.app.binarytree;

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

 // approach : using dfs
 // we can traverse the tree using dfs and keep track of the time taken to infect all nodes
 // when we reach the node with the given start value, we can infect its left and right
 // subtrees and keep track of max time taken to infect all nodes in the subtree.

class Solution {
    int res = 0 ;
    public int amountOfTime(TreeNode root, int start) {
        if (root == null)
            return 0;

        dfs( root, start);
        return res;
    }

    public int dfs(TreeNode n , int start){

        if ( n!=null){
            
            if ( n.val  == start ){
                addMinutes( n.left ,  1 );
                addMinutes( n.right , 1 );
                return 1;
            }

            int l =  dfs ( n.left, start );
            if ( l != -1){
                res = Math.max(res, l);
                addMinutes( n.right , l+1 );
                return l+1;
            } else {
                
                int r= dfs ( n.right , start);

                if ( r != -1 ){
                    res = Math.max(res, r);
                    addMinutes( n.left , r+1 );
                    return r+1;
                }

            }
        
        }
        return -1;
    }

    public void addMinutes( TreeNode n , int minutes){
        if ( n!=null){
            res = Math.max(res, minutes);
            addMinutes( n.left , minutes+1 );
            addMinutes( n.right , minutes+1 );
        }
    }
}