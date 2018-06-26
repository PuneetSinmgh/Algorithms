package my.com.app;

public class LinkedListStack {

	private Node head;
	
	private class Node{
		
		private String data;
		private Node next;
		
	}
	
	
	public void push(String s) {
		
		Node oldhead = head;
		
		head = new Node();
		head.data = s;
		head.next = oldhead;
		
//		oldhead.next = head;
	}
	
	public String pop() {
		
		Node deleted = head;
		head = head.next;
		deleted.next = null;
		
		return deleted.data ;
	}
	
	public Boolean IsEmpty() {
		return head==null;
	}
	
	public void print() {
		Node x = head;
		
		while (x != null ) {
			System.out.println(x.data);
			x = x.next;
		}
			
			
	}
}
