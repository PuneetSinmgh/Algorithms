package my.com.app.binarysearchtree;

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
public class Codec {
/** 
    // Encodes a tree to a single string in preorder traversal.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        createString(sb, root);
        sb = sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    public void createString(StringBuilder sb , TreeNode root){
        if(root==null){
            return;
        }
        sb.append(root.val+",");
        createString(sb,root.left);
        createString(sb,root.right);        
    }

    // Decodes your encoded data to tree. by finding the right value for the char
    public TreeNode deserialize(String data) {
        if(data.length()==0)
            return null;
        String[] values = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        for(int i=1 ; i<values.length ; i++){
            findPos(Integer.parseInt(values[i]),root);       
        }
        
        return root;
    }
    public void findPos(int val, TreeNode node){
        
        if(val < node.val){
            
            if(node.left == null)
                node.left= new TreeNode(val);
            else
                findPos(val,node.left);
        }else{
            if(node.right == null)
                node.right = new TreeNode(val);
            else
                findPos(val, node.right);
        }
    }*/

    /* serialize by inorder traversal
    
    StringBuilder sb = new StringBuilder();

    public String serialize(TreeNode root) {
        if ( root==null)
            return "";
        runSer(root);
        sb = sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public void runSer( TreeNode root){
        if ( root==null)
            return ;
        
        runSer(root.left);
        sb.append(root.val+",");
        runSer(root.right);
    }

    // deserialize using binary serach algorithm
    public TreeNode deserialize(String data) {
        
        if(data.length()==0)
            return null;

        System.out.println("data :"+ data);
        String[] values = data.split(",");
        int start = 0, end = values.length -1;
        
        return binary( values, start, end);
    }

    public TreeNode binary(String[] data, int start, int end) {
        if(start==end){
            return new TreeNode( Integer.parseInt( data[start]));
        }

        int mid = start + (end-start)/2;
        
        TreeNode root = new TreeNode( Integer.parseInt( data[mid]));
        root.left = binary( data, start, mid-1);
        root.right = binary( data, mid+1, end );
        
        return root;        
    }
    */

    // serialize by postorder traversal
    public StringBuilder postorder(TreeNode root, StringBuilder sb) {
        if (root == null)
            return sb;
        postorder(root.left, sb);
        postorder(root.right, sb);
        sb.append(root.val);
        sb.append(' ');
        return sb;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = postorder(root, new StringBuilder());
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
        if (nums.isEmpty())
            return null;
        int val = nums.getLast();
        if (val < lower || val > upper)
            return null;

        nums.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(val, upper, nums);
        root.left = helper(lower, val, nums);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
        for (String s : data.split("\\s+"))
            nums.add(Integer.valueOf(s));
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;