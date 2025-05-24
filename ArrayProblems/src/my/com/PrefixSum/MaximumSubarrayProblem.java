package my.com.prefixsum;

// Maximum Subarray Problem : max sum of  // contiguous subarray
// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.



public class MaximumSubarrayProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	class Solution1 {
	    public int maxSubArray(int[] nums) {
	     
	        int i , sum =0, max_sum=nums[0];
	        if(nums.length== 0)
	            return 0;
	        for(i=0;i<nums.length;i++){
	            
	            if(sum<0)
	                sum=nums[i];
	            else
	                sum = sum + nums[i];
	            
	            if(sum > max_sum )
	                max_sum = sum ;
	            
	        }
	    
	    return max_sum;
	    }
	}
	
	
	
	class Solution2 {
	    public int maxSubArray(int[] nums) {
	     
	        if(nums.length == 0)
	            return 0;
	        
	        return  maxSubArraySum(nums,0,nums.length-1);
	    }
	    
	    public int maxSubArraySum(int[] nums, int start ,int end){
	        
	        if(start == end)
	            return nums[start];
	        
	        int p = (start+end)/2;
	        
	        int l = maxSubArraySum(nums,start,p);
	        int r = maxSubArraySum(nums,p+1,end);
	        int c = maxCrossingSubarray(nums,start,p,end);
	        
	        return Math.max(c, Math.max(l,r));
	    }
	    
	    
	    public int maxCrossingSubarray(int[] nums , int start, int mid, int end){
	        
	        int i=mid,j=mid+1, sumleft=0, maxleftSum=Integer.MIN_VALUE, maxRightSum = Integer.MIN_VALUE , sumright=0;
	    
	        while(i>=start){
	             sumleft += nums[i];
	             if(maxleftSum < sumleft){
	                 maxleftSum  = sumleft;
	             }
	             i--;
	         }
	        
	        while(j<=end){
	            sumright += nums[j];
	            if(maxRightSum < sumright){
	                maxRightSum = sumright;
	            }
	            
	            j++;
	        }
	        
	        return maxleftSum + maxRightSum;
	    }
	}
}
