// Minimum value to get positive step sum
package my.com.prefixsum;

// // Minimum value to get positive step sum
// Given an array of integers nums, you start with an initial positive value startValue.
// In each iteration, you calculate the step sum of nums, which is the sum of all elements in nums.


// Approach : Find min prefix sum and return the absolute value of min prefix sum + 1
class Solution {
    public int minStartValue(int[] nums) {
        
        int sum =0 , minSum = Integer.MAX_VALUE; 
        for (int i=0; i<nums.length; i++){
            sum = sum +nums[i];

            if ( sum < minSum ){
                minSum = sum;
            }
        }

        if (minSum<0){
            return Math.abs(minSum) +1;
        } 
        
        return 1;
    }
}