package my.com.app;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// Create a copy of node , already not created .
// maintain a map of the nodes already created
// and return the copy of the node if already created

class Solution {
    
    public Node cloneGraph(Node node) {
        if ( node == null)
            return null;
        HashMap<Integer, Node> hm = new HashMap();
        
        return dfs(hm , node);
    }
    
    public Node dfs(HashMap<Integer ,Node> hm, Node curr ){
        if ( hm.containsKey(curr.val)){
            return hm.get(curr.val);
        }
        
        Node copyNode = new  Node( curr.val);
        
        hm.put( copyNode.val, copyNode);
        
        for ( Node n  : curr.neighbors) {
            if (!hm.containsKey(n.val) ){
                Node copyn =  dfs( hm, n);
                copyNode.neighbors.add(copyn);
            } else {
                copyNode.neighbors.add(hm.get(n.val) );
            }
                
        }
        
        return copyNode;
        
    }
}