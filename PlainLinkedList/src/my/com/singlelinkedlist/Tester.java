package my.com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Tester {

	public static void main(String[] args) {
		

		InputStreamReader in = new InputStreamReader(System.in);
		 BufferedReader br = new BufferedReader(in);
		
		LinkedListImplementation linkdImp1 = new LinkedListImplementation();
		LinkedListImplementation linkdImp2 = new LinkedListImplementation(); 
		 String line = null;
		 try {
			 
			 line = br.readLine();
			 String[] words = line.split(",");
	 
				for (String s : words) {
				int i = Integer.parseInt(s);
				linkdImp1.addAtTail(i);
				}	
				
				line = br.readLine();
				 String[] list = line.split(",");
		 
					for (String s : list) {
					int i = Integer.parseInt(s);
					linkdImp2.addAtTail(i);
					}	
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 LinkedListOperations rm = new LinkedListOperations();
		 Node sum = rm.intersection(linkdImp1.getHead(), linkdImp2.getHead());
		 /*
		 if(duplicate==null) {
			 System.out.println("No duplicates");
		 }
		 else {
			 System.out.println("duplicate value:"+ duplicate.data);
		 }*/
		System.out.println("\n result : \n ");
		while(sum!=null) {
			System.out.println(sum.data);
			sum = sum.next;
		}

	}

}
