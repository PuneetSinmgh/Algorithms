package src.my.com.app;

import java.util.*;

// Delete and Earn

//Approach:
// 1. Create a  map for max value earned for each numbers for the array.
// 2. Create a dp array to store the maximum points that can be earned by deleting numbers. 


class Solution {
    public int deleteAndEarn(int[] nums) {
        // frquency map
        // [2,2,3,3,3,4]
        // [2,2,4,4,6,6] dp = [ ]
        // [ 2, 3, 4]   dp = [4, 9 , ]
        // 
        // group number and find there sum, iterate over the set of number 

        if ( nums.length ==1)
            return nums[0];

        HashMap<Integer, Integer> hm = new HashMap();
        int max = 0 ;
        for(int i=0 ;i < nums.length; i++){
                hm.put( nums[i], hm.getOrDefault(nums[i], 0)+nums[i]);
                max = Math.max( max ,nums[i] );
        }
        
        int[] dp = new int[ max + 1];
        dp[0] = 0;
        dp[1] = hm.getOrDefault(1 ,0);

        int max_res = dp[1] ; 
        for(int i=0 ; i <=max ; i++){
            int num = i;
            if ( num > 1){
                dp[num] = Math.max( dp[num-1] , dp[num-2] + hm.getOrDefault(num, 0));
                max_res = Math.max( max_res , dp[num]);
            }
        }
        return max_res;
    }
}