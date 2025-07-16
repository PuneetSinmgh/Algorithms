package my.com.app.grid_dp;
import java.util.*;
// Unique Paths with Obstacles
// Approach: Use dynamic programming to find the number of unique paths from the top-left corner to the bottom-right corner of a grid with obstacles.
// We can either move down or right at each step, but we need to account for obstacles in the grid. 


class Solution {
    
    Integer[][] lookup;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       
        
        
        int i=0, j=0; 
        
        lookup = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1)
            return 0;
        
        return getPaths(i, j,obstacleGrid );
    }
    public int getPaths(int i, int j, int[][] obstacleGrid ){
        
        if(i>= obstacleGrid.length || j>=obstacleGrid[0].length)
            return 0;
        
        if(i==obstacleGrid.length-1 && j==obstacleGrid[0].length-1){
            lookup[i][j] = 1;
            return lookup[i][j];
        }
            
        
        if(obstacleGrid[i][j] == 1)
            return 0;
        
        if(lookup[i][j] == null){
            lookup[i][j] = getPaths(i+1,j,obstacleGrid ) + getPaths(i,j+1,obstacleGrid );
            return lookup[i][j] ;
        }
        
        return lookup[i][j];
    }
    
    
    /* Bottom up approach
    
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    
    int[][] grid = new int[m][n];
    
     if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1)
            return 0;
        
    for(int i = m-1; i>=0; i--){
        for(int j= n-1; j>=0; j--){
            
            if(obstacleGrid[i][j] == 1){
                    grid[i][j] = 0;
            }else{
                if(i == m-1 && j== n-1){
                    grid[i][j] = 1;
                }
                else if(i == m-1 && j<n-1){
                    grid[i][j] = grid[i][j+1];
                }
                else if(j== n-1 && i < m-1){
                    grid[i][j] = grid[i+1][j];
                }    
                
                else{ 
                        grid[i][j] = grid[i][j+1] + grid[i+1][j];    
                }    
            }
            
            
        }
    }  
     
        return grid[0][0];
    }*/
    
}