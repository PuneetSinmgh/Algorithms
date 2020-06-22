package my.com.app;

public class MergeTosortedArray {

	public static void main(String[] args) {
		
	}

	public int[] merged(int[] nums1, int[] nums2) {
		 		
		int[] mergedarr = new int[nums1.length+nums2.length];
	        int i=0 , j =0,k=0;
	        
	        while(i<nums1.length && j<nums2.length){
	            if(nums1[i] <= nums2[j]){
	                mergedarr[k] = nums1[i];
	                i++;
	            
	            }else{
	                mergedarr[k] = nums2[j];
	                j++;
	            }
	            k++;
	        }
	        
	        if(i==nums1.length && j<nums2.length){
	            while(j<nums2.length){
	                mergedarr[k] = nums2[j];
	                j++;
	                k++;
	            } 
	        }
	        else if(j==nums2.length && i<nums1.length){
	            while(i<nums1.length){
	                mergedarr[k] = nums1[i];
	                i++;
	                k++;
	            }
	        }
	 
	return mergedarr;
	}
	
}
