package my.com.matrix;
import java.util.*;

// approach :
// 1. find the max of each column and min of each row
// 2. check if the element is equal to the max of its column and min of its row
// 3. if yes, add it to the result list  

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        

        int[] col_max = new int[matrix[0].length];
        int[] row_min = new int[matrix.length];

        Arrays.fill( row_min , Integer.MAX_VALUE);

        for ( int i=0 ; i < matrix.length; i++) {
            
            for ( int j=0 ; j< matrix[0].length; j++){

                col_max[j]  = Math.max(col_max[j] , matrix[i][j] );      

                row_min[i] = Math.min( row_min[i] , matrix[i][j] );

            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i=0 ; i < matrix.length; i++ ) {

            for ( int j=0 ; j< matrix[0].length; j++){

                if ( matrix[i][j] == row_min[i] && matrix[i][j] == col_max[j]){
                    res.add( matrix[i][j] );
                }
            }
        }

        return res;
    }
}