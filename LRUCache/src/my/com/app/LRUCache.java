package my.com.app;

import java.util.*;

class Node{
	Node pre;
    Node post;
    int val;
    int key;
    
    public Node(int key,int val){
        this.pre = null;
        this.post = null;
        this.val = val;
        this.key = key;
    }
}
class DoublyLinkedList{

	Node recent;
	Node least;
	int capacity;
	int size;

	public DoublyLinkedList(int cap){
	    this.capacity = cap;
	    this.recent  = null;
	    this.least = null;
	    this.size=0;
	}

	public Node add(Node newNode){
	    
	    Node n = newNode;
	    if(recent != null){
	        this.recent.pre = n;
	        n.post = recent;
	    }
	    
	    if(recent==null && least ==null){
	        least = n;
	    }
	    recent = n;
	    size++;
	    return recent;
	}
	
	public Node remove(Node n){
	   
	    n.pre.post = n.post;
	    if(n.post!=null){
	        n.post.pre = n.pre;
	    }
	    
	    if(this.least == n)
	           this.least = n.pre;
	    
	    n.pre =null;
	    n.post =null;
	    size--;	    
	    return n;
	}
	
	public int currentsize(){
	    return this.size;
	}
	public boolean isEmpty(){
	    return this.size==0?true : false;
	}
	public boolean isFull(){
	    return this.size == this.capacity?true: false;
	}
	
	public void updateToRecent(Node n){
        if(n!= this.recent) {	
	        this.remove(n);
		    this.add(n);
	    }
    }

}

public class LRUCache {

	   Map<Integer, Node> hm ;
	   // Map< Node , Integer> nodetoKeymap ;
	    DoublyLinkedList dll;
	    int capacity;
	        
	    public LRUCache(int capacity) {
	        this.hm = new HashMap<Integer,Node>();
	     //   this.nodetoKeymap = new HashMap<Node,Integer>();
	        this.dll = new DoublyLinkedList(capacity);
	        this.capacity = capacity;
	    }
	    public int get(int key) {
	     
	        if(this.hm.size()==0)
	            return -1;
	  
	        Node n = hm.getOrDefault(key,null);
	        
	        if(n!=null){    // updating the cache to make n most recent
	         this.dll.updateToRecent(n);
	        }
	        
	        return n==null?-1:n.val;
	    }
	    
	    public void put(int key, int value) {
	        Node n = hm.getOrDefault(key,null);
	        if(n!=null){
	            n.val = value;
                this.dll.updateToRecent(n);
	        }
	        else{
	            if(this.dll.isFull()){
	              Node r = this.dll.remove(this.dll.least);
	              hm.remove(r.key, r);
	              //nodetoKeymap.remove(r);
	              r = null;
	            }
	            Node newNode = new Node(key , value);
	           // Integer i = new Integer(key);
	            hm.put(key,this.dll.add(newNode));
	           // nodetoKeymap.put(newNode, i);
	        }
	    }
	}

	
	
	

