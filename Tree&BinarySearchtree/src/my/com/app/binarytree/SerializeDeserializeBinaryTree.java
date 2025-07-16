package my.com.app.binarytree ;

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
public class SerializeDeserializeBinaryTree {

    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    public void serializeHelper(TreeNode root , StringBuilder sb){
            if(sb.length()==0){
                sb.append(root.val);
            } else{
                sb.append(",").append(root.val);
            }
        
            

            if(root.left !=null)
                serializeHelper(root.left, sb);
            else
                sb.append(",").append("null");

            if(root.right !=null)
                serializeHelper(root.right,sb);
            else
                sb.append(",").append("null");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.length() == 0)
            return null;
        
        String[] vals = data.split(",");
        
        Deque<String> que = new ArrayDeque();
        
        for(String s : vals){
              que.add(s);
        }
        
        return deserializeHelper(que);
        
    }
    
    public TreeNode deserializeHelper(Deque<String> que ){
        
        if(que.peek().equals("null")){
            que.remove();
            return null;
        }
        
        TreeNode n = new TreeNode(Integer.valueOf(que.remove()));
            
            
            n.left = deserializeHelper(que);
            n.right = deserializeHelper(que);
            return n;
        
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));