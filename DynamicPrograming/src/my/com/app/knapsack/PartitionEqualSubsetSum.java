package my.com.app.knapsack;
import java.util.*;
// Approach: Use dynamic programming to solve the subset sum problem.
// problem staetement: Given an array of integers, can we partition it into two subsets such that the sum of both subsets is equal?

// The problem can be reduced to checking if there exists a subset of the array that sums up to half of the total sum of the array.


// We will create a 2D boolean array dp where dp[i][j] will be true if a subset of the first i elements can sum up to j.
// We will iterate through the array and update the dp array based on whether we include or exclude the current element.

class Solution {
    
    Boolean[][] dp ;
    
    public boolean canPartition(int[] nums) {
    
        int sum = Arrays.stream(nums).sum();
        // since we cannot choose fractional elements, thus id total sum is odd , it can't be devided in equally
        if ( sum%2 != 0)
            return false;

        sum /=2;
        dp = new Boolean[nums.length][sum+1]; // using memoization 

        return subsetSum(nums,0 , sum);

    }

    public boolean subsetSum(int[] nums, int idx, int target){

        if (target == 0)
            return true;
        
        if (target<0 || idx == nums.length)
            return false;

        if (dp[idx][target] != null)   
            return dp[idx][target];

        dp[idx][target] = subsetSum(nums, idx+1 , target-nums[idx]) || subsetSum(nums, idx+1 , target);
        return dp[idx][target];
    }
}