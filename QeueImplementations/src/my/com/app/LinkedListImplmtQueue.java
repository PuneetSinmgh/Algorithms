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
			n.data = s;
			if(last!=null) {
				last.next = n;
			}
			last = n;
			if(first == null) {
				first = last;
			}
				
		}
		public String dequeue() {
			
			if (first==null)
				return "Queue is empty" ;
			else {
				Node deleted = first;
				first=first.next;
				
				if(first==null) {
					last = null;
				}
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

