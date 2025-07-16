package my.com.prefixsum;

import java.util.*;

// problem statement:
// Given an integer arraay nums , find maximum product of a contiguous subarray.
// A subarray is a contiguous part of an array.

// approach:
// 1. Brute force: calculate product of all subarrays and return the maximum product
// 2. Optimized approach: use two variables to keep track of maximum and minimum product
//    - If the current number is negative, swap the maximum and minimum product
//    - Update the maximum product as the maximum of the current number, maximum product multiplied by the current number, and minimum product multiplied by the current number
//    - Update the minimum product as the minimum of the current number, maximum product multiplied by the current number, and minimum product multiplied by the current number
//    - Return the maximum product at the end
// Time Complexity: O(n)
// Space Complexity: O(1)
public class maximumProductSubArray {

    public int maxProduct(int[] nums) {
        
        /* brute force
        int prod = 1;
        
        int maxprod = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            
            prod =1;
            for(int j=i ;j<nums.length;j++){
                
                prod = nums[j] * prod;
                
                maxprod = Math.max(prod, maxprod);
            }
        }
        return maxprod; */
        
        int maxprod = 1;
        int minprod = 1;
        
        int res = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            
            int tempmax = Math.max(nums[i], Math.max(maxprod * nums[i] , minprod * nums[i]));
            
            minprod = Math.min(nums[i], Math.min(maxprod * nums[i] , minprod * nums[i]));
            
            maxprod = tempmax;
            
            res = Math.max(res, maxprod);
        }
        
        return res;
    }
}