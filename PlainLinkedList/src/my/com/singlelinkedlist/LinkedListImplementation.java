package my.com.singlelinkedlist;

import my.com.singlelinkedlist.*;

public class LinkedListImplementation implements LinkedList {
	
	private Node head;
	private Node tail;
	
	public LinkedListImplementation() {
	
		head =null ;
		tail = null;
		
	}
	
	public Node getHead() {
		return this.head;
	}
	public Node getTail() {
		return this.tail;
		
	}
	
	public void setHead(Node n) {
		this.head = n ;
	}
	public void setTail(Node n) {
		this.tail = n ;
	}
	@Override
	public void addAtHead(int val) {
		if(head == null) {
			Node n = new Node(val);
			n.data = val;
			head = n ;
			tail = n ;
		}
		else {
			
			Node n =new Node(val);
			n.next = head;
			head = n ;
		}
	}

	@Override
	public void addAtTail(int val) {
		if(tail == null) {
			Node n = new Node(val);
			n.data = val;
			head = n ;
			tail = n ;
		}
		else {
			Node n =new Node(val);
			tail.next = n;
			tail = n;
		}
	}

	
    public void addAtIndex(int index, int val) {
        
        if  (index == 0) {
            addAtHead(val);
            return;
        }

        Node temp = head;
        int i =0 ;

        while( temp !=null ){
            if(i == index-1){
                break;
            }
            temp = temp.next;
            i++;
        }
        
        if ( temp !=null){
            if ( tail == temp){
                addAtTail(val);
                return;
            }
            Node n = new Node(val);
            n.next = temp.next;
            temp.next = n;
            
        }
        
    }
    
    public void deleteAtIndex(int index) {
        Node temp = head;
        if (index == 0 ){
            if (temp!=null){
                head = temp.next;
                temp.next = null;
            }
            return;
        }
        
        int i = 0; 
        while( temp!=null ){
            if(i == index-1){
                break;
            }
            temp = temp.next;
            i++;
        }
        if(temp == null)
            return;
            
        if (temp.next!=null){
            if(tail == temp.next){
                tail = temp;
            }
            Node t = temp.next;
            temp.next = t.next;
            t.next = null;
        }
    }

    @Override
    public void delete(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void insert(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
}
