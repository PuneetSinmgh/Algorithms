package my.com.prefixsum;

public class ArrayProductExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
	    public int[] productExceptSelf(int[] nums) {
	        
	        if(nums.length == 0)
	            return new int[0];
	        int prod=1;
	        int[] forward = new int[nums.length];
	        int[] backward = new int[nums.length];
	        for(int i=0; i<nums.length; i++){
	            if(i==0)
	                prod *=1;
	            else
	                prod = prod * nums[i-1];
	            forward[i] = prod;
	        }
	        prod =1;
	        for(int i=nums.length-1; i>=0; i--){
	            if(i==nums.length-1)
	                prod *=1;
	            else
	                prod = prod *nums[i+1];
	            backward[i] = prod;
	        }
	        
	        System.out.println(forward);
	        System.out.println(backward);
	        
	        for(int i=0; i<nums.length; i++){
	            
	            forward[i] = forward[i]*backward[i];
	            
	        }
	        
	        return forward;
	    }
	}
	
	
}
