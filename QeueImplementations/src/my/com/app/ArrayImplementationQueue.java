package my.com.app;

public class ArrayImplementationQueue {

	private String[] queuearr;
	private int head, tail;
	
	public ArrayImplementationQueue() {
		
		queuearr = new String[1];
		head=0;
		tail=0;
	}
	
	public void enqueue(String s) {
		if(head == 0 && tail == 0) {
			queuearr[tail]= s;
			++tail;
		}
		else {
			if(tail-head == queuearr.length ) {
				//System.out.println("len:"+queuearr.length);
				resize(queuearr.length *2);
			}
			System.out.println(tail-head);
			System.out.println("lena:"+queuearr.length);
			queuearr[tail]=s;  
			++tail;
		}
			
	}
	
	public void resize(int capacity) {
		String [] copy = new String[capacity];
		int i , k ;
		for(i=0, k=head; i< tail-head ; i++, k++) {
			copy[i] = queuearr[k];
		}
		queuearr = copy;
		System.out.println("copylen:"+ queuearr.length);
		head = 0 ;
		tail = i;
	}
	public String dequeue() {
		
		String s = queuearr[head]; 
		queuearr[head]= null;
		++head;
		if (tail-head == queuearr.length/ 2)
			resize(queuearr.length/2);
		return s;
	}
	
	public Boolean isEmpty() {
		return head == -1 && tail == -1;	
	}
	
	public void print() {
		for(int i = head; i <= tail ; i++)
			System.out.println(queuearr[i]);
	}
}
