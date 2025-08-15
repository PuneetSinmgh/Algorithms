package my.com.app;

import java.util.*;
/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */


public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length;i++){
            for (int j=0;j<board[i].length; j++){
                if(board[i][j]== word.charAt(0) &&  wordsearch(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean wordsearch(char[][] board, String word, int i,int j,int k){
        
        if(k == word.length())
            return true;
        
        if(i>board.length-1 || i<0 || j>board[0].length -1 || j<0 || board[i][j] != word.charAt(k))
            return false;
        
        
            char temp = board[i][j];
            board[i][j] = ' ';
            
            boolean found = wordsearch(board, word, i, j-1,k+1) ||
                        wordsearch(board, word, i, j+1,k+1) ||
                        wordsearch(board, word, i-1, j,k+1) ||
                        wordsearch(board, word, i+1, j,k+1);
            board[i][j] = temp;
            return found;
        
    
    }
}