package my.com.bfs;


import java.util.*;

class Node{
    int r;
    int c;
    int pathcount;
    Node(int r , int c , int p){
        this.r = r ;
        this.c = c ;
        this.pathcount = p;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int len = grid.length;
        if (len ==0)
            return -1;
        if ( grid[0][0] == 1 || grid[len-1][len-1] == 1)
            return -1;
        // use a queu to store the next position of path by using formula : i*r+c
        // check for corner case for 8 directional cells and add to the path.
     
        ArrayDeque<Node> queue = new ArrayDeque() ;
        
        int[][] operations = { {-1,-1},{-1,0},{-1,+1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        
        queue.add( new Node(0, 0, 1));
        while( !queue.isEmpty()){
            
            int size = queue.size();
            for( int i=0 ; i<size; i++){
                
                Node n = queue.poll();
                if ( n.r == len-1 && n.c == len-1 ){
                    return n.pathcount;
                }
                for ( int[] op : operations){

                    int r = n.r + op[0];
                    int c = n.c + op[1];
                    
                    if ( r>=0 && r<len && c>=0 && c<len && grid[r][c] == 0 ){
                        // add to the queue and increase the count of node visited
                        if ( r == len-1 && c == len-1 ){
                            return n.pathcount+1;
                        }
                        queue.add( new Node( r, c, n.pathcount+1));
                    }
                    
                }
                // reset the last visited cell to 1
                grid[n.r][n.c] = 1;
                
            }
        }
        
        return -1;
    }
}