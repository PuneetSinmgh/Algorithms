package my.com.app;

public class MedainofSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        
	        if(nums1 == null || nums1.length == 0 )
	            return median(nums2);
	        
	        if(nums2 == null || nums2.length == 0)
	            return median(nums1);
	        
	        System.out.println(median(nums1));
	        System.out.println(median(nums2));
	        
	        return  (median(nums1) + median(nums2)) / 2.0;
	        
	    }
	    
	    public double median(int[] nums){
	        
	        double res;
	        int len = nums.length;
	        if(len % 2 == 0){
	            res = (nums[(len/2)-1] + nums[(len/2)]) / 2;
	        }
	        else{
	            res = nums[((len+1)/2) -1];
	        }
	        
	        return res;
	    }
	}
	
	
	class Solution2 {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        
	        
	        if(nums2.length < nums1.length){
	            return findMedianSortedArrays(nums2,nums1);
	        }
	        
	        int x = nums1.length;
	        int y = nums2.length;
	        
	        
	        int partitionx , partitiony , left_max , right_min, max_lefty, min_righty; 
	        int start = 0, end=x;
	        double result = 0.0;
	        while(start <= end){
	            
	            partitionx = (start+end)/2;
	            
	            partitiony = (x+y+1)/2 - partitionx;
	        
	            left_max = partitionx==0? Integer.MIN_VALUE : nums1[partitionx-1];
	            right_min = partitionx==x? Integer.MAX_VALUE : nums1[partitionx];
	            
	            
	            max_lefty = (partitiony==0)? Integer.MIN_VALUE: nums2[partitiony-1];
	            min_righty = (partitiony==y)? Integer.MAX_VALUE: nums2[partitiony];
	            
	            if(left_max <= min_righty && max_lefty <= right_min){
	                
	                if((x+y)%2 == 0){
	                    result = (double)(Math.max(left_max , max_lefty) +
	                             Math.min(right_min , min_righty)) / 2;
	                }else{
	                    result = (double)Math.max( left_max, max_lefty );
	                }
	            }
	            else if (left_max > min_righty){
	                end = partitionx-1;
	            }else {
	                start = partitionx+1;
	            }
	        }
	        
	        return result;
	    
	    }
	}
}
