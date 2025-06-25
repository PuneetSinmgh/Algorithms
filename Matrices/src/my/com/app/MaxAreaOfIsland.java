package my.com.app;
import java.util.*;
// approach 1 : using dfs 
// approach 2 : using bfs


class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        ArrayDeque<Integer> q = new ArrayDeque<Integer>();

        int max_area = 0 , area =0;

        for(int i =0 ; i < grid.length ; i++){
            for(int j=0 ; j< grid[0].length; j++){

            /*
                if ( grid[i][j] == 0)
                    continue;
                if ( grid[i][j] == 1) {

                    q.add(i * grid[0].length + j);
                    area = 1 ;
                    grid[i][j] = 0;
                    while( !q.isEmpty()) {

                        int val = q.poll();
                        int r = val/ grid[0].length;
                        int c = val % grid[0].length;
                        

                        if( r-1 >=0 && grid[r-1][c]==1){
                            area +=1;
                            q.add( (r-1) * grid[0].length + c );
                            grid[r-1][c] = 0;
                        }
                        if( r+1<grid.length && grid[r+1][c]==1){
                            area +=1;
                            q.add( (r+1) * grid[0].length + c );
                            grid[r+1][c] = 0;
                        }
                        if( c-1 >=0 && grid[r][c-1]==1){
                            area +=1;
                            q.add( (r) * grid[0].length + (c-1) );
                            grid[r][c-1] = 0;
                        }
                        if( c+1< grid[0].length && grid[r][c+1]==1 ){
                            area +=1;
                            q.add( (r) * grid[0].length + (c+1) );
                            grid[r][c+1] = 0;
                        }
                    }

                    if (area > max_area)
                        max_area = area;
                }
            */
                max_area = Math.max( dfs(grid, i, j, area), max_area );
            }
        }   
        return max_area;
    }

    public int dfs( int[][] grid, int r , int c , int area ){
        if ( 0 > r || r == grid.length || 0 >c || c== grid[0].length || grid[r][c] == 0 ){
            return 0;
        }

        if (grid[r][c] == 1) {
            
                area += 1;
            grid[r][c] = 0;         

        area = 1 + dfs( grid, r-1, c, area) 
        + dfs( grid, r+1, c, area)
        + dfs( grid, r, c-1, area)
        + dfs( grid, r, c+1, area);
        }
        
        return area;
    }

}