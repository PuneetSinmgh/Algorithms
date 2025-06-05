package src.my.com.app;

import java.util.*;

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
    int max;
    public int longestUnivaluePath(TreeNode root) {
        max =0;
        
        path(root ,-1);

        return max;
    }
    
    public int path(TreeNode root  , int parent){

        if ( root == null)
            return 0;

        int left = path(root.left, root.val );

        int right = path( root.right, root.val );
                
        max = Math.max( max , left + right ); // compare max value 
    
        return root.val == parent ? Math.max(left, right) + 1 : 0; // return the max continous path 
    }
}