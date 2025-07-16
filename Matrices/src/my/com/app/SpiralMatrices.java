package my.com.app;

import java.util.*;
// Spiral Order Matrix
// Given an m x n matrix, return all elements of the matrix in spiral order.

// runtimte complexity: O(m*n)  
// space complexity: O(1) if we don't consider the output array

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
     
        if(matrix.length == 0 )
            return new ArrayList();
        int rl =0 , ru = matrix.length -1 ,i=0;
        int cl =0, cu = matrix[0].length -1, j=0;
        
        
        List<Integer>  res = new ArrayList();
        
        while( rl<=ru && cl<=cu){
            
            for( i=rl, j=cl; j <=cu; j++){
                res.add(matrix[i][j]);
            }
                
            for(i=rl+1, j =cu; i<=ru ;i++){
                res.add(matrix[i][j]);
            }
            
            if(rl < ru && cl<cu){
            
                    for(i=ru, j=cu-1; j>cl;j--){
                        res.add(matrix[i][j]);
                    }   
            
                    for(i=ru , j= cl; i>rl ; i--){
                        res.add(matrix[i][j]);
                    }
            }
            
            
            rl++ ; cu--; ru--;cl++;
        }
     
        return res;
    }
}
