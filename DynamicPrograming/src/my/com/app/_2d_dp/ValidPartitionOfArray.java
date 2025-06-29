package my.com.app._2d_dp;

import java.util.*;


// approach using memoization
// Time Complexity: O(n)
// Space Complexity: O(n)
// where n is the length of the input array
//// The idea is to check if the prefix of the array up to index i can be partitioned
// into valid pairs or triplets. We use a recursive function with memoization to avoid redundant
// calculations. The function checks three conditions:  
// 1. If the last two elements are equal, it checks if the prefix up to i-2 is valid.
// 2. If the last three elements are equal, it checks if the prefix up to i-3 is valid.
// 3. If the last three elements form a consecutive sequence, it checks if the prefix up to i-3 is valid.
// If any of these conditions hold true, the function returns true, indicating that the prefix can be partitioned
// into valid pairs or triplets. If none of the conditions hold, it returns false.
// The memoization map stores the results of previously computed indices to avoid redundant calculations, improving the efficiency of the solution.
// The final result is obtained by checking if the prefix up to the last index can be partitioned into valid pairs or triplets.


class Solution {
    Boolean[][] dp ;
    
    Map<Integer, Boolean> memo = new HashMap<>();

    public boolean validPartition(int[] nums) {
      /*
        int n = nums.length;
        if (n < 2)
            return false;
        
        dp = new Boolean[n][n];

        return recursivePartition(nums, 0, nums.length-1);
        */

        int n = nums.length;
        memo.put(-1, true);

        return prefixIsValid( nums, n-1);
    }

    boolean prefixIsValid(int[] nums, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        boolean ans = false;

        // Check 3 possibilities
        if (i > 0 && nums[i] == nums[i - 1]) {
            ans |= prefixIsValid(nums, i - 2);
        }
        if (i > 1 && nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) {
            ans |= prefixIsValid(nums, i - 3);
        }
        if (i > 1 && nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1) {
            ans |= prefixIsValid(nums, i - 3);
        }
        memo.put(i, ans);
        return ans;
    }

    public boolean recursivePartition( int[] nums , int s , int e ){

        if ( dp[s][e] != null)
            return dp[s][e];

        if( e-s +1 ==3){
            if ( (nums[s] == nums[s+1] && nums[s+1] == nums[s+2]) || 
                ( nums[s] +1 == nums[s+1] && nums[s+1] +1 == nums[s+2] )){
                    dp[s][e] =  true;
                    return dp[s][e];
                } else{
                    dp[s][e] =  false;
                    return dp[s][e];
                }
        } else if (e-s+1 == 2){
            if ( nums[s] == nums[e]){
                dp[s][e] =  true;
                return dp[s][e];
            } else{
                    dp[s][e] =  false;
                    return dp[s][e];
            }
        } else if (e-s+1 < 2 ){
            dp[s][e] =  false;
            return dp[s][e];
        }
        
        for ( int i =s ; i< e ;i++){
            if  (recursivePartition(nums, s, i) && recursivePartition(nums, i+1, e)){
                dp[s][e] =  true;
                return dp[s][e];
            }
        }

        dp[s][e] =  false;
        return dp[s][e];
    }
}