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
// perform breadth first search
class Solution { 
    public List<Integer> largestValues(TreeNode root) {
        
        // Run bfs and find the max value at each row 
        List<Integer> res = new ArrayList();
        if(root== null)
            return res;
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        queue.add(root);

        while(!queue.isEmpty()){

            int n = queue.size();
            int max = Integer.MIN_VALUE;
            for ( int i=0; i<n; i++){
                
                TreeNode node = queue.poll();
                max = Math.max(max , node.val);
                if ( node.left!=null)
                    queue.add(node.left);
                
                if ( node.right!=null)
                    queue.add(node.right);
            }
            res.add(max);
        }
        return res;
    }

    /*
     * Time Complexity: O(n) where n is the number of nodes in the tree.
     * Space Complexity: O(n) for the queue used in BFS.
     * 
     * 
    DFS Solution :
    public List<Integer> largestValues(TreeNode root) {
        // dfs
        // Time O(n)
        // Space O(n)

        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    private void dfs(TreeNode root, int level, List<Integer> list) {
        if(root == null) return;

        if(level >= list.size()) {
            list.add(root.val);
        } else {
            list.set(level, Math.max(list.get(level), root.val));
        }

        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    } 
    */
}