package my.com.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestGenerics {

	public static void main () {
		
		Integer[] arrayofInteger = new Integer[10];
		
		//List<Integer> newlist = new List<>(); // because list is an interface and we cannot create objects of interface 
		
		Object objarr = new Integer[10];// Object is super class of all the classes and thus , the reference objarr points to an array of integers
		
		
		List<Integer> aList = new LinkedList<>(); // work fine , declaration of new generic linked list
		
		//List<Object> objList = new LinkedList<Integer>(); // generic are invariant thus subclass type generic cannot be stored into superclass generic 
		
		
		//List[] aryofLL = new LinkedList[10];// array of linked list 
		
		LinkedList[] aryofLL = new LinkedList[10];// array of linked list
		
		
		
		
		//LinkedList<Integer>[]  arrayofLinkedlist = new LinkedList<>[10]; // generic type array of linked list
		
		
		
		
	}
	
}
