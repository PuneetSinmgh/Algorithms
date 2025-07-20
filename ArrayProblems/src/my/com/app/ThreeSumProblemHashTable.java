package my.com.app;

import java.util.HashMap;
import java.util.*;


public class ThreeSumProblemHashTable {

	public static void main(String[] args) {
		

	}

	class Solution {
	    
	    
	    class Comparat implements Comparator<Integer>{
	         
	        public int compare(Integer i1 , Integer i2){
	                return i1>i2?1:-1;
	            }
	        }
	    
	    public List<List<Integer>> threeSum(int[] nums) {
	     
	        if(nums.length<3)
	            return new ArrayList<>();
	        List<List<Integer>> res = new ArrayList<>();
	        Map<Integer,List<Integer>> ht = new HashMap<>();
	        
	        List<Integer> l1,l2;
	        for(int i=0;i<nums.length; i++){
	            
	            if(ht.containsKey(nums[i])){
	                l1 = ht.get(nums[i]);
	                l1.add(i);
	                ht.put(nums[i], l1);
	            }else{
	                l1 = new ArrayList<>();
	                l1.add(i);
	                ht.put(nums[i],l1);
	            }
	        }
	        
	        
	        int comp;
	        Comparat c = new Comparat();
	        for(int i=0; i<nums.length-1; i++){
	            for(int j=i+1; j<nums.length; j++){
	                
	                comp = 0 - nums[i] - nums[j];
	                if(ht.containsKey(comp)){
	                    l1 = ht.get(comp);
	                    for(Integer k : l1){
	                        if(i!=k && j!=k && i!=j){
	                            l2 = new ArrayList<>();
	                            l2.add(nums[i]);
	                            l2.add(nums[j]);
	                            l2.add(nums[k]);
	                            l2.sort(c);
	                            if(res.size()!=0  && !res.contains(l2)){
	                                res.add(l2);
	                            }
	                            else{
	                                if(res.size()==0)
	                                    res.add(l2);
	                            }
	                            l2 =null;
	                        }
	                    }
	                }
	                
	            }
	        }
	        
	    return res;
	    }
	    
	    
	}
}
