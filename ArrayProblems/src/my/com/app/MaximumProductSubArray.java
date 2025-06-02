package src.my.com.app;

import java.util.*;

class Solution {
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