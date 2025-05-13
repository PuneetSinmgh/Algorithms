package my.com.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    public List<Integer> preorder(Node root) {
        // preorder root comes before
        List<Integer> l = new ArrayList();
        dfs(root, l);
        return l;
    }
    
    public void dfs( Node root, List<Integer> lc) {
      if ( root == null)
          return;
        
        lc.add(root.val);
        for ( Node n : root.children){
            dfs(n, lc); 
        }
    }


    public List<Integer> postorder(Node root) {
        // postorder root comes after
        List<Integer> l = new ArrayList();
        dfsPost(root, l);
        return l;
    }
    
    public void dfsPost( Node root, List<Integer> lc) {
      if ( root == null)
          return;
        
        for ( Node n : root.children){
            dfsPost(n, lc); 
        }
        lc.add(root.val);
    }

    // Level order traversal
    public List<List<Integer>> levelOrder(Node root) {
        if ( root == null)
            return new ArrayList();
        ArrayDeque<Node> que = new ArrayDeque();
        List<List<Integer>> res = new ArrayList();
        que.add(root);
        while ( !que.isEmpty()){
            
            int size = que.size();
            
            List<Integer> l = new ArrayList();
            for ( int i=0 ; i<size; i++ ){
                
                Node n = que.poll();
                if ( n!=null){
                     l.add( n.val);
                     for( Node c : n.children ){
                        que.add(c); 
                    }   
                }
            }
            res.add(l);
        }
        return res;
    }
}
// Compare this snippet from Tree%26BinarySearchtree/src/my/com/app/LevelOrderTraversal.java: