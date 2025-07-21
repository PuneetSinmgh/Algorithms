package my.com.app.knapsack;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /* 
    public int lengthOfLIS(int[] nums) {
        
        return findLISLength( nums, 0 );
    }

    public int findLISLength(int[] nums, int idx){

        if ( idx == )
            return 0;
        
        if ( idx == nums.length-1)
            return 1;
            
        if ( nums[idx+1] > nums[idx])
            return 1 + findLISLength( nums, idx+1 );
        else
            return Math.max( 1,  findLISLength( nums, idx+1 ));

    } */

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max( dp[i], dp[j] + 1 );
                }
            }
        }
        
        int longest = 0;
        for (int c: dp) {
            longest = Math.max(longest, c);
        }
        
        return longest;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + lis.lengthOfLIS(nums)); // Output: 4
    }
          
}
