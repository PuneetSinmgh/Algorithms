package src.my.com.prefixsum;

import java.util.*;

class Solution {
    public long minTotalTime(int[] forward, int[] backward, int[] queries) {
        long[] forwardSum = new long[forward.length];
        int n = forward.length;
        forwardSum[0] = 0;
        for (int i=1 ;i<n; i++){
            forwardSum[i] = forwardSum[i-1] + forward[i-1]; // saving forward path to keep simplified
        }
        
        int forwardLoopBack  = forward[n-1];

        long[] backwardSum = new long[backward.length];
        backwardSum[n-1] = 0;
        for (int i=n-1 ;i>0 ; i--){

            backwardSum[i-1] = backwardSum[i] + backward[i]; // saving backward path to keep simplified

        }
        int backwardLoopBack = backward[0];

        long res = 0;
        int prev = 0; 
        for ( int i=0; i<queries.length; i++){
            long bsum = 0;
            long fsum  = 0;
            int q = queries[i];

            if ( q > prev){ // min of forward path and backward path
                
                if ( prev == 0 ) {
                    bsum = backwardLoopBack +  backwardSum[q];
                } else {
                    bsum  = backwardSum[0] - backwardSum[prev] + backwardLoopBack + backwardSum[q];
                }

                res += Math.min( forwardSum[q] - forwardSum[prev] , bsum );

            } else {
                
                if ( prev == n-1){
                    fsum = forwardLoopBack + forwardSum[q];
                } else {
                    fsum = (forwardSum[n-1] - forwardSum[prev]) +  forwardLoopBack + forwardSum[q];
                }
                res +=  Math.min( fsum ,   backwardSum[q] - backwardSum[prev] );
            }
            prev = q;
        }

        return res;
    }
}