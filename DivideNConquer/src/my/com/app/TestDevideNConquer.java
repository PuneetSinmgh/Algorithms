package my.com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestDevideNConquer {

	public static void main(String[] args) {
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		Scanner sc = new Scanner(in);
		
		int len = sc.nextInt();
		
		int[] profits = new int[len]; 
		int[] weights = new int[len];
		 
		 String line = null;
		 try {
			 
			 line = br.readLine();
			 String[] words = line.split(" ");
			 for(int i =0 ; i <len ; i++) {
				 profits[i] = Integer.parseInt(words[i]);
			 }
			 
			 line = br.readLine();
			 String[] wstr = line.split(" ");
			 for(int i =0 ; i <len ; i++) {
				 weights[i] = Integer.parseInt(wstr[i]);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 int capacity= sc.nextInt();
		 
		 System.out.print(knapsack(profits,weights,capacity));
		 sc.close();
		 
	}
	
	public static int knapsack(int[] profits , int[] weights, int capacity) {
		
		return knapsacaux(profits, weights, capacity,0);
		
	}
	
	public static int knapsacaux(int[] profits , int[]weights, int capacity , int index) {
		
		if(capacity<=0 || index >= profits.length || index<0)
			return 0;
		
		int profit1=0 , profit2=0;
		if(weights[index]<=capacity) {
			profit1 = profits[index] + knapsacaux(profits, weights, capacity - weights[index], index+1);
		}
		profit2 = knapsacaux(profits, weights, capacity, index+1);
		
		return Math.max(profit1, profit2);
	}
	
}
