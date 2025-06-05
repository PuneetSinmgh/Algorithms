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

    HashMap<Integer, Integer> preHm = new HashMap();
    HashMap<Integer, Integer> postHm = new HashMap();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
        if ( preorder[0] !=  postorder[postorder.length-1]){
            return null;
        }

        for ( int i=0 ; i < preorder.length; i++){
            preHm.put( preorder[i], i);
        }

        for ( int i=0 ; i < postorder.length; i++){
            postHm.put( postorder[i], i);
        }

        return getNode(preorder , postorder, 0 , preorder.length-1 , 0 , postorder.length-1);
    }

    public TreeNode getNode(int[] preorder, int[] postorder, int preSt, int preEnd, int postSt, int postEd) {

        if (preSt > preEnd) 
            return null;
        if ( preSt == preEnd )
            return new TreeNode(preorder[preSt]);

        TreeNode  node = new TreeNode(postorder[postEd]);
        int idx  =  preHm.get( node.val);

        int rightSubTreeRootIdx = preHm.get( postorder[postEd-1]);
        int leftSubTreeRootIdx = preHm.get( preorder[preSt+1]);

        if (leftSubTreeRootIdx == rightSubTreeRootIdx ){
            int len = preEnd - idx;
            node.right = getNode(preorder , postorder, idx + 1, idx + len , postSt , postSt + len -1 );
            return node;
        }

        int leftSubTreeLen =  rightSubTreeRootIdx - idx - 1 ;
        int rightSubTreeLen =  preEnd - rightSubTreeRootIdx +1;


        
           
        //int leftSubtreeRootInd = preHm.get( preorder[])
        // calculate left subtree length and 
        

        if (leftSubTreeLen <= 0 ){
            return null;
        } else {
            node.left = getNode(preorder , postorder, idx + 1, idx + leftSubTreeLen , postSt , postSt + leftSubTreeLen -1 );
        }

        if (rightSubTreeLen <= 0) {
            return null;
        } else {
            int righIdx = postHm.get( postorder[postEd-1]);
            node.right = getNode( preorder , postorder, rightSubTreeRootIdx , preEnd  , righIdx - rightSubTreeLen +1  , righIdx);
        }

        return node;
    }
}