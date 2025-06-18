package my.com.app.binarysearchtree;

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
    List<Long> levelSum = new ArrayList();
    // this can be done using dfs and bfs both , and also by using a PQ
    public long kthLargestLevelSum(TreeNode root, int k) {
        dfs(root, 1);
        Collections.sort(levelSum, Collections.reverseOrder());
        if ( k >levelSum.size() )
            return -1;
        return levelSum.get(k-1);
    }

    public void dfs(TreeNode root, int level){

        if ( root!= null){
            dfs( root.left, level+1);
            while( levelSum.size()<level)
                levelSum.add(0L);

            levelSum.set(level-1, root.val+levelSum.get(level-1) );
            dfs( root.right, level+1);
        }
    }
}