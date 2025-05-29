pakage my.com.app;

import java.util.*;
// Minimum Operations to Make the Array Strictly Increasing
// Given an array of integers nums, you can perform the following operation any number of times:
// Approach : Sort the array and use a HashSet to keep track of distinct elements.
// If a number is already present in the HashSet, increment it until it becomes distinct. 
// Choose two indices i and j where 0 <= i < j < nums.length and nums[i] >= nums[j].
// Increment nums[j] by 1.
// Return the minimum number of operations to make the array strictly increasing.

class Solution {
    public int minIncrementForUnique(int[] nums) {
        
        HashSet<Integer> hs = new HashSet();
        
        int min_op = 0;

        Arrays.sort(nums);
    
        for (int i =0; i < nums.length; i++){
            
            if ( hs.contains( nums[i])){ // check if curr nums is already seen , if yes keep incrementing to make it to closest distict number
                int val = nums[i];
                
                min_op +=  nums[i-1] +1 - nums[i]; // add no of operations to reach upto distinct number
                nums[i] = nums[i-1] +1;
            } 
            

            hs.add(nums[i]);
        }

        return min_op;
    }
}