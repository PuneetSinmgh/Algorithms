class Solution {
    public long minTotalTime(int[] forward, int[] backward, int[] queries) {
        int[] forwardSum = new int[forward.length];
        int n = forward.length;
        forwardSum[0] = 0;
        for (int i=1 ;i<n; i++){
            forwardSum[i] = forwardSum[i-1] + forward[i-1]; // saving forward path to keep simplified
        }
        
        int forwardLoopBack  = forward[n-1];

        int[] backwardSum = new int[backward.length];
        backwardSum[n-1] = 0;
        for (int i=n-1 ;i>0 ; i--){

            backwardSum[i-1] = backwardSum[i] + backward[i]; // saving backward path to keep simplified

        }
        int backwardLoopBack = backward[0];

        int res = 0;
        int prev = 0; 
        for ( int i=0; i<queries.length; i++){
            
            int q = queries[i];
            if ( q > prev){ // min of forward path and backward path
                int bsum  = backwardSum[0] - backwardSum[prev] + backwardLoopBack + backwardSum[q];
                res += Math.min( forwardSum[q] - forwardSum[prev] , bsum );

            } else {
                int fsum = (forwardSum[n-1] - forwardSum[q]) +  forwardLoopBack + forwardSum[prev];
                res +=  Math.min( fsum ,  backwardSum[prev] - backwardSum[q] );
            }
            prev = q;
        }

        return res;
    }
}