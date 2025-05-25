package my.com.app.backtrack;

import java.util.*;

// Find all possible combinations of tiles
// Given a string tiles representing the letters of a set of tiles, return the number of possible non-empty sequences of letters you can make using the letters.

// Approach: Use backtracking to generate all possible combinations of the tiles.
// The idea is to use a depth-first search (DFS) approach to explore all combinations of the tiles, keeping track of used tiles to avoid duplicates.

class Solution {
    public int numTilePossibilities(String tiles) {
        if (tiles.length() == 1)
            return 1;

        char[] arr = tiles.toCharArray();
        boolean[] used = new boolean[tiles.length()];

        HashSet<String> hs = new HashSet();

        dfs( arr , "" , used , hs );

        return hs.size()-1 ;
    }

    public void dfs( char[] arr, String sb , boolean[] used  , HashSet<String> hs){


            hs.add(sb);

            for(int i =0 ; i < arr.length  ; i++){
                
                if ( !used[i]){
                    used[i] = true;
                    dfs( arr , sb + arr[i], used , hs );
                    used[i] = false;
                }
                
            }
    }    
}