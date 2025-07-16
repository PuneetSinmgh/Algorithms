package my.com.app;

import java.util.*;
// jump game: approach : 
// 1. Recursion
// 2. Dynamic Programming
// 3. Greedy : 
class Solution {

    int[] dp;
    public boolean canJump(int[] nums) {
     /*     
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
        
       
        return jumps(nums,0);
    }
    public boolean jumps (int[] nums , int idx){
     
        if(idx == nums.length-1){
            return true;
        }
        
        int maxjump = Math.min(idx+nums[idx], nums.length-1);
        
        for(int i=idx+1 ; i<= maxjump;i++){
            
            if(jumps(nums,i))
                return true;
            
        }
        return false; */

    /*    dp = new int[nums.length];
        
        Arrays.fill(nums, -1);
        dp[nums.length - 1] = 1;
        
        return reachLast(nums, 0 );

    }

    public boolean reachLast( int[] nums, int idx){
        if (  dp[idx] != -1 )
            return dp[idx] == 1 ? true : false;

        int maxJump = Math.min( idx + nums[idx], nums.length-1 );

        for (int i= idx+1 ; i<= maxJump ; i++) { // since maximum number of step is val, so we can take any step between 1 to val
            if (reachLast(nums, i )){
                dp[idx] = 1;
                return true;
            }
        }
        
        dp[idx] = 0;
        return false;

    */

    // Greedy solution 


        int last = nums.length-1;

        for ( int i = nums.length-1 ; i >=0 ; i-- ){

            if ( i +nums[i] >= last ){
                last = i;
            }
        }

        return last == 0;
    }
}