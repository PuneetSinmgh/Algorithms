package my.com.app;

import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PermutationOfArray {

	
	 public static List<List<Integer>> permute(int[] nums) {
	        
	        List<List<Integer>> res = new ArrayList();
	        
	        backtrack(0 ,res,nums,new ArrayList());
	     
	        return res;
	    }
	    
	    public static void backtrack(int j,List<List<Integer>> res, int[] nums, List<Integer> l){
	        
	        if(l.size()==nums.length)
	            return;
	        for(int i =0 ; i <nums.length; i++){
	              
	            if(!l.contains(nums[i])){   
	            	
	            	if(j==l.size()-1){
	                    l.set(j,nums[i]);   
	                }
	                else{
	                    l.add(nums[i]);
	                }
	                    
	                backtrack(j+1,res,nums,l);
	            }    
	        }
	        
	        if(l.size() == nums.length){
	            res.add(new ArrayList(l));
	        }
	        l.remove(l.size()-1);
	    }
	
	public static void main(String[] args) {
		
		InputStreamReader in = new InputStreamReader(System.in);
		Scanner sc = new Scanner(in);
		BufferedReader br = new BufferedReader(in);
		int len = sc.nextInt();
		
		int[] nums = new int[len]; 
		
		 
		String line = null;
		 try {
			 
			 line = br.readLine();
			 String[] words = line.split(",");
			 for(int i =0 ; i <words.length ; i++) {
				 nums[i] = Integer.parseInt(words[i]);
			 }
			 
		System.out.print(permute(nums));	 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
