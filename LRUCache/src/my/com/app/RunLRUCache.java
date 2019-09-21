package my.com.app;

import java.util.*;

public class RunLRUCache {

	public static void main(String[] args) {
		
		 
		Scanner sc = new Scanner(System.in);
		System.out.println(" enter the capacity:");
		int cap = sc.nextInt();
		
		 LRUCache obj = new LRUCache(cap);
		 System.out.println("enter 2,1 pair:");
		 int param_key = sc.nextInt();
		 int param_val = sc.nextInt();
		 
		 obj.put(param_key,param_val);
		 /*
		 System.out.println("enter 2,2 pair:");
		  param_key = sc.nextInt();
		  param_val = sc.nextInt();
		 
		  obj.put(param_key,param_val);
		 */ 
		  System.out.println("enter get 2");
		  
		  param_val = sc.nextInt();
		  System.out.println("return value : " + obj.get(param_val));

		  System.out.println("enter 3,2 pair:");
		  param_key = sc.nextInt();
		  param_val = sc.nextInt();
		  obj.put(param_key,param_val);
		 
		  System.out.println("enter get 2");
		  param_val = sc.nextInt();
		  System.out.println("return value : " + obj.get(param_val));
/*
		  System.out.println("enter 4,4 pair:");
		  param_key = sc.nextInt();
		  param_val = sc.nextInt();
		  obj.put(param_key,param_val);
		 
		  System.out.println("enter get 1");
		  param_val = sc.nextInt();
		  System.out.println("return value : " + obj.get(param_val));
*/
		  System.out.println("enter get 3");
		  param_val = sc.nextInt();
		  System.out.println("return value : " + obj.get(param_val));

	/*	  System.out.println("enter get 4");
		  param_val = sc.nextInt();
		  System.out.println("return value : " + obj.get(param_val));
*/
	}

}
