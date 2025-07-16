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
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null)
            return new ArrayList();

         List<List<Integer>> res = new ArrayList();
        TreeNode head = root;
        while( head!=null){
            
            List<Integer> l = new ArrayList();
            head = dfs(root, l);
            res.add(l);
        }

        return res;
    }

    public TreeNode dfs(TreeNode root , List<Integer> l){
        if (root == null)
            return root;

        if ( root.left == null && root.right == null){
            l.add(root.val);
            return null;
        }

        root.left = dfs(root.left, l);
        root.right = dfs(root.right , l);
        return root;
    }
}