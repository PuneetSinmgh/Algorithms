package my.com.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int maxArea(int[] height) {
 
        if(height.length == 0)
            return 0;
        int left=0, right=height.length-1;
        int maxarea = Integer.MIN_VALUE, temparea ; 
        while(left<right){
            
            if(height[left] < height[right]){
                temparea = height[left]*(right - left);
                left++;
            }
            else{
                temparea = height[right]*(right - left);
                right--;
            }
            
            if(temparea > maxarea){
                maxarea = temparea;
            }
            else{
                maxarea = maxarea;    
            }
            
        }
        
    return maxarea;
    }


	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println("Max Area: " + sol.maxArea(height)); // Output: 49
	}
}	