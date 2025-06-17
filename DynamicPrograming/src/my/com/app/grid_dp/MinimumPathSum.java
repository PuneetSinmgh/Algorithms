package my.com.app.grid_dp;
// Minimum Path Sum
// Approach: Use dynamic programming to find the minimum path sum from the top-left to the bottom
// right of a grid. We can maintain a dp array where dp[i][j] represents the minimum path sum to reach cell (i, j).
// We can fill this dp array by considering the minimum path sum from the top or left cell.
// Recursive approach is also possible but not efficient for larger inputs.
// Explain recursive approach:
// 1. Base Case: If we reach the bottom-right cell, return its value.
// 2. Recursive Case: For each cell, we can either move down or right.
// We take the minimum of the two possible paths and add the current cell's value to it
// 3. If we go out of bounds, return a large value (infinity) to avoid considering that path.

import java.util.*;

class Solution {
    Integer[][] dp ;
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        if(m==1&&n==1)
            return grid[0][0];
        
        dp = new Integer[m][n];
        
        return getMinPathSum(grid, m, n , 0, 0);
    }

    public int getMinPathSum(int[][] grid, int m, int n, int i, int j){
        
        if(i>=m || j>=n)
            return Integer.MAX_VALUE;
        
        if(i==m-1 && j==n-1)
            return grid[i][j];

        if ( dp[i][j] != null)
            return dp[i][j];

        dp[i][j] = grid[i][j] + Math.min( getMinPathSum(grid, m, n, i+1, j) , getMinPathSum(grid, m, n, i, j+1) );
        return dp[i][j];
    }
}