package my.com.singlelinkedlist;


public class Node {

	int data;
	Node next;
	
	public Node(int d) {
		data = d;
		next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
