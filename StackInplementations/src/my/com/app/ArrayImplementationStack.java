  package my.com.app;



public class ArrayImplementationStack {

	String[] stackarr; 
	int head;
	
	public ArrayImplementationStack() {
		stackarr = new String [1];
		head = -1;
	}
	
	public void push(String s) {
		
		if(head==stackarr.length-1) 	
			resize(stackarr.length *2);
		stackarr[++head] = s;
	}
	
	public void resize(int capacity) {
		
	String copy[] = new String[capacity];
		for (int i =0 ; i<=head  ; i++)
			copy[i]= stackarr[i];
		stackarr = copy;
	}
	
	public String pop() {
		
		String s = stackarr[head];   // amortized analysis decrease the size of the stack by half, when the head is at length/4 
		
		if (head >0 && head==stackarr.length/4)
			resize(stackarr.length/2);
		
		stackarr[head]=null;
		--head;
		return s;
	}
	
	public boolean IsEmpty() {
		
		return head == -1;
	}
	
	public void print() {
		
		System.out.println("stack array:\n");
		for(int i =0; i<=head; i++){
			System.out.println(stackarr[i]);
		}
	}
}
