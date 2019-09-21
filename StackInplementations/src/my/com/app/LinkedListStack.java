package my.com.app;

public class LinkedListStack<T> {

	private Node head; 
	
	private static class Node<T>{
		
		private T data;
		private Node next;
		
	}
	
	
	public void push(T s) {
		
		Node oldhead = head;
		
		head = new Node();
		head.data = s;
		head.next = oldhead;
		
//		oldhead.next = head;
	}
	
	public T pop() {
		
		Node deleted = head;
		head = head.next;
		deleted.next = null;
		
		return (T) deleted.data ;
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
	
	public T peek() {
		if(head!=null)
			return (T) head.data;
		
		return null;
	}
}
