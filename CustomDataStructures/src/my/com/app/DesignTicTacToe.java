package my.com.app;

import java.util.*;

// approach : This approachs uses a 2D array to represent the Tic Tac Toe board.
// Each cell in the array can be -1 (empty), 0 (player 1's move), or 1 (player 2's move).
// The move method checks the row, column, and diagonals for a win condition after each move.
// If a player wins, it returns the player's number (0 or 1).
// If no player wins, it returns 0.
// The time complexity is O(n) for each move, where n is the size of the board
// The space complexity is O(n^2) for the 2D array representing the board

class TicTacToe {

    int[][] arr ;

    public TicTacToe(int n) {
        this.arr = new int[n][n];
        for (int[] a : this.arr){
             Arrays.fill(a, -1); 
        }    
    }
    
    public int move(int row, int col, int player) {
        int flag = 0 , n = arr.length;
        arr[row][col] = player;
        // for row r check all values in that row
        for ( int i = 0 ;i < n ;i++ ){
            if(arr[row][i] != player) {
                flag = 1;
                break;
            }
        }
        
        if (flag == 0){
            return player;
        } else {
            flag = 0;
        }
       
        // for col c check all values in that col
        for ( int i = 0 ;i < n ;i++ ){
            if(arr[i][col] != player){
                flag = 1;
                break;
            }
        }
        if (flag == 0){
            return player;
        } else {
            flag = 0;
        }
        
        // check for daigonal
        if ( row == col) {
            for ( int i = 0 ;i < n ; i++ ){
                if(arr[i][i] != player){
                    flag = 1;
                    break;
                }
            }   
        }else {
            flag = 1;
        }
        if (flag == 0){
            return player;
        } else {
            flag = 0;
        }
        
        if ( row + col == n-1) {
            for ( int i = 0 ;i < n ; i++ ){
                if(arr[i][(n-1) - i]!= player){
                    flag = 1;
                    break;
                }
            }
        } else {
            flag = 1;
        }
        if (flag == 0){
            return player;
        } else {
            flag = 0;
        }
        
    return 0;
    }
}

// Optimized approach : Instead of checking all rows, columns, and diagonals every time a move is made,
// we can keep track of the number of moves made by each player in each row, column, and diagonal.
// We can use two arrays to keep track of the counts for each player in each row, column, and diagonal.
// This way, we only need to check the counts after each move
// and can determine if a player has won in O(1) time.

// The time complexity is O(1) for each move, and the space complexity is O(n) for the arrays used to track counts.
// This is a significant improvement over the previous approach, especially for larger boards.

class OptimizedTicTacToe {

    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public OptimizedTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currp = (player == 1) ? 1 : -1;
        int n = rows.length;

        rows[row] += currp;
        cols[col] += currp;

        // update diagonal
        if (row == col) {
            diagonal += currp;
        }

        //update anti diagonal
        if (col == (n-1 - row)) {
            antiDiagonal += currp;
        }

        if (Math.abs(rows[row]) == n || // to win any player has to mark one row or col n times 
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }
        
        return 0;
    }
}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */