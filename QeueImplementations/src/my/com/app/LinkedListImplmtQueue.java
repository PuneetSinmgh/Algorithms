package my.com.app;

public class LinkedListImplmtQueue {

		private Node first, last;
	
		public LinkedListImplmtQueue() {
			first = null;
			last = null;
		}
		public class Node{
			String data;
			Node next;			
		}
	
		public void enqueue(String s) {
			Node n = new Node();
			n.data= s;
			n.next = null;
			if(first == null && last== null) {
				first = n ; 
				last=n;
			}
			else {
				last.next = n ;
				last= n;
			}
			
		}
		public String dequeue() {
			
			if (first==null)
				return "Queue is empty" ;
			else {
				Node deleted = first;
				first=first.next;
				return deleted.data;
			}
		}
		public Boolean isEmpty() {
			return first == null&&last==null;
		}
		public void print() {
			
			Node i= first;
			while(i!=null) {
				System.out.println(i.data);
				i = i.next;
			}
					
			
		}
}

