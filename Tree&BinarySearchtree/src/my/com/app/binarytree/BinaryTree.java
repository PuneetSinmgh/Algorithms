package my.com.app;

import java.util.LinkedList;

public class BinaryTree {

	class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int data) {
			data = data;
		}
	}
	
	public void insertNode(TreeNode root) {
		
		
		
	}
	
	public TreeNode deleteNode() {
		return null;
	}
	
	public TreeNode searchNode() {
		return null;
	}
	public boolean validateBST() {
		return true;
	}
	
}



 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     }
 
class Solution {
    int res=0; 
    int c=0;
    
    public int pathSum(TreeNode root, int sum) {
    
        LinkedList<TreeNode> queue = new LinkedList();
        int count =0;
        
        
        if(root==null)
            return 0;
        
        queue.add(root);
           
        while(!queue.isEmpty()){
            
            TreeNode n = queue.remove();
            
            count += calcPathSum(n,sum);
            c=0;
            res=0;
            if(n.left!=null)
                queue.add(n.left);
            if(n.right!=null)
                queue.add(n.right);
         
        }        
         
    return count;
    }
    public int calcPathSum(TreeNode root , int sum){
        
        if(root==null)
           return c;
        
        res = root.val+res;
        if(res == sum){
            c+=1;
        }
    
        calcPathSum(root.left,sum); 
        calcPathSum(root.right,sum);
        res = res - root.val;
        
      return c;  
    }
}