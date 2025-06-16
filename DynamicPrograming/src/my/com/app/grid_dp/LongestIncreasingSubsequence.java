package src.my.com.app.grid_dp;
import java.util.*;
// Longest Increasing Subsequence
// Approach: Use dynamic programming to find the length of the longest increasing subsequence in an array.
// We can maintain a dp array where dp[i] represents the length of the longest increasing subsequence that ends with nums[i].
// We iterate through the array and for each element, we check all previous elements to see if we can extend the subsequence.   

// recursive approach is also possible but not efficient for larger inputs.
// Explain recursive approach:
// 1. Base Case: If the array is empty, the length of the longest increasing subsequence is 0.
// 2. Recursive Case: For each element in the array, we can either include it in the subsequence or not.

class Solution {
     public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int longest = 0;
        for (int c: dp) {
            longest = Math.max(longest, c);
        }
        
        return longest;
    }
}