package my.com.app.grid_dp;

import java.util.*;
// Unique Paths
// Approach: Use dynamic programming to find the number of unique paths from the top-left corner to the bottom-right corner of a grid.
// We can either move down or right at each step, so we can use a recursive function with memoization to calculate the number of unique paths.

class Solution {
    
    Integer[][] dp ;
    public int uniquePaths(int m, int n) {
         
        int i=0, j=0; 
        
        if(m==1&&n==1)
            return 1;
        
        dp = new Integer[m][n];
        return getPaths(m, n , i, j);
        
    }
    public int getPaths(int m,int n, int i, int j){
        
        if(i>=m || j>=n)
            return 0;
        
        if(i==m-1 && j==n-1)
            return 1;
        
        if ( dp[i][j] != null)
            return dp[i][j];

        dp[i][j] = getPaths(m,n,i+1,j) + getPaths(m,n,i,j+1);
        return dp[i][j];
    }

        
    /* bottom up approach
        
    int[][] grid = new int[m][n];
        
    for(int i = m-1; i>=0; i--){
        for(int j= n-1; j>=0; j--){
            
            if(i == m-1 || j== n-1){
                grid[i][j] = 1;
            }
            else{
                grid[i][j] = grid[i][j+1] + grid[i+1][j];    
            }
        }
    }  
     
        return grid[0][0];
    }*/
}