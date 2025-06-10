package src.my.com.app.binarytree;

import java.util.*;

//approach is to find the target node and then traverse the tree to find all nodes at distance k from the target node
// then traverse the tree to find all nodes at distance k from the target node
// if the target node is found in the left subtree, then traverse the right subtree to find all nodes at distance k from the target node
// if the target node is found in the right subtree, then traverse the left subtree to find all nodes at distance k from the target node


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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList();
        
        dfs(root,target,k,res);
        
        return res;
    }
    
    public int dfs(TreeNode root, TreeNode target, int k, List<Integer> res){
        
        if(root != null){

            if(root.val == target.val){
                if(k==0)
                    res.add(root.val);
                
                addNode(root.left,1, k, res);
                addNode(root.right,1 , k, res);
            return 1;
                
            }else{
                
                int l = dfs(root.left,target,k,res);
                if(l!=-1){
                    // found in left tree, then add nodes from right tree
                    if(l==k)
                        res.add(root.val);
                    addNode(root.right,l+1, k, res);
                    return l+1;
                }else{
                    int r = dfs(root.right,target,k,res);
                    if(r!=-1){
                        if(r==k)
                            res.add(root.val);
                        
                        addNode(root.left,r+1, k, res);
                        return r+1;
                    }
                }
            }
        }
        return -1;
    }
    
    public void addNode(TreeNode root , int d, int k,List<Integer> res){
        if(root==null)
            return ;
        if(d == k){
            res.add(root.val);
        }else if(d<k){
            addNode(root.left,d+1 , k, res);
            addNode(root.right,d+1 , k, res);
        }    
    }
}