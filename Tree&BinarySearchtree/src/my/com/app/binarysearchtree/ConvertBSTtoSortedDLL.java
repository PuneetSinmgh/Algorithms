package my.com.app.binarysearchtree;


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};


class Solution {
    
    class Dll{
        Node head;
        Node tail;
        
        public Dll(){
            head = null;
            tail = null;
        }
        
        public void add(Node n){
            
            if(head == null)
                head = n;
            
            if(tail!=null)
                tail.right = n;
            
            n.left = tail;
            tail = n;
            head.left = n;
        }
    }
    public Node treeToDoublyList(Node root) {
        if(root== null)
            return null;
        
        Dll dll = new Dll();
        
        transform(root, dll);
        
        dll.tail.right = dll.head;
        return dll.head;
    }
    
    public void transform(Node root , Dll dll){
        
        if(root!=null){
            
            transform(root.left , dll);
            dll.add(root);
            transform(root.right, dll);
        }

    } 
}