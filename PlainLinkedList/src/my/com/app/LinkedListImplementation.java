package my.com.app;

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

	@Override
	public void delete(int index) {
		
		
		
	}

	@Override
	public void insert(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int get(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
