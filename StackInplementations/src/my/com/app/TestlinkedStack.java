package my.com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestlinkedStack {

	
	public static void main(String args[]) {
		
		InputStreamReader in = new InputStreamReader(System.in);
		 BufferedReader br = new BufferedReader(in);
		
		 //ArrayImplementationStack stack = new ArrayImplementationStack();
		 LinkedListStack<Integer> stack = new LinkedListStack<>();
		 
		 String line = null;
		 try {
			 
			 line = br.readLine();
			 String[] words = line.split(" ");
	 
				for (String s : words) {
					stack.push(Integer.parseInt(s));
				}	
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 stack.print();
		 
	}
	
}
