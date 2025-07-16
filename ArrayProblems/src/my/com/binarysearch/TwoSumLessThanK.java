package my.com.binarysearch;

import java.util.*;

// approach:    
// 1. Sort the array
// 2. For each element, use binary search to find the largest element that can be paired with it such that their sum is less than k.
// 3. Keep track of the maximum sum found that is less than k.
// 4. Return the maximum sum found, or -1   


class Solution {
    public int twoSumLessThanK(int[] nums, int k) {

    // using binary search    
        if ( nums.length < 2)
            return -1 ; 
        
        Arrays.sort(nums);
        int max_sum = Integer.MIN_VALUE;

        for( int i=0 ; i < nums.length; i++){


            int idx = Arrays.binarySearch( nums,i + 1, nums.length,  k - nums[i] -1 );
            int j = ( idx >= 0 ? idx : ~idx);
            
             if (j == nums.length || nums[j] > k - nums[i] - 1) {
                j--;
            }
            if (j > i) {
                max_sum = Math.max(max_sum, nums[i] + nums[j]);
            }
        }
        return max_sum == Integer.MIN_VALUE ? -1 : max_sum;
    }
}