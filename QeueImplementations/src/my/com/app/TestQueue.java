package my.com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestQueue {

	public static void main(String[] args) {

		
		InputStreamReader in = new InputStreamReader(System.in);
		 BufferedReader br = new BufferedReader(in);
		
		ArrayImplementationQueue aqueue = new ArrayImplementationQueue();
		 
		 String line = null;
		 try {
			 
			 line = br.readLine();
			 String[] words = line.split(" ");
	 
				for (String s : words) {
					if (s.equals("-"))
					 aqueue.dequeue();
					else 
					aqueue.enqueue(s);
				}	
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 aqueue.print();
		 
	}
		


}
