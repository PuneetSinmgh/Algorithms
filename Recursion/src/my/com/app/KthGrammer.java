package my.com.app;

import java.util.*;

class Solution {
    // each level is equal to prev layer plus the reverse of previous layer
    /*   0.         n=1
         01.        n=2
    *    0110.      n=3
    *    01101001.  n=4
    */

    public int kthGrammar(int n, int k) {
         
        return getNth(n, k);
    }
    
    public int getNth(int n, int k){
        
        if (n==1)
            return 0;
        
        int numOfDigit = (int) Math.pow(2, n-1); 
        int half = numOfDigit/2;

        if ( k > half)
            return 1 - getNth(n , k - half );  // if k is more than half , then on current row , reverse bit of ( k - half index). 

        return getNth( n-1 , k);
    }
    
}