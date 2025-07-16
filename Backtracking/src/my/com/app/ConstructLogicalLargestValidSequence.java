package my.com.app;

import java.util.*;

class Solution {
    public int[] constructDistancedSequence(int n) {
        
        int[] res = new int[2*n-1];
        boolean[] seen = new boolean[n+1];

        backtrack( res , seen , n , 0);
        return res;
    }

    public boolean backtrack(int[] res , boolean[] seen, int n , int idx){

        if ( idx  == res.length)
            return true;
        
        if ( res[idx]!=0){
            return  backtrack( res , seen , n , idx+1); // or move to next index
        }

        for ( int i=n; i>=1 ;i-- ){
            
            if (seen[i])
                continue;
            
            seen[i] = true;
            res[idx] = i;

            if ( i ==1){
                if ( backtrack( res , seen , n , idx+1))
                    return true;
            }else if ( i+idx < res.length && res[i+idx] == 0 ){

                res[ i+idx ] = i; // placing the second number

                if ( backtrack( res , seen , n , idx+1))
                    return true;

                res[i+idx] =0;
            }

            res[idx] = 0;
            seen[i] = false;
        }
        return false;
    }
}