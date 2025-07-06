package src.my.com.mergeintervals;

import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        
        if ( intervals.length == 1 ){
            if ( intervals[0][0] == intervals[0][1])
                return new int[]{0};
            else
                return new int[]{-1};
        }

        HashMap<Integer, Integer> hm = new HashMap();

        int[] result = new int[intervals.length];

        int[] sortedStart = new int[intervals.length];

        for(  int i=0 ;i < intervals.length; i++ ){
            sortedStart[i] =  intervals[i][0];
            hm.put(intervals[i][0] , i );
        }
        Arrays.sort( sortedStart);

        // iterate over the interval array
        for ( int i=0 ; i<sortedStart.length; i++) {

            int idx = hm.get(sortedStart[i]);

            if (intervals[idx][1] == sortedStart[i]){
                
                result[idx] = idx;
            
            }
            else {
                // search for smallest interval-start greated than current end index 
                int ridx = Arrays.binarySearch( sortedStart, i , sortedStart.length , intervals[idx][1] ) ;
                
                if ( ridx < 0)
                    ridx = (-1*ridx) -1;

                if ( ridx == sortedStart.length )
                    result[idx] = -1;
                else
                    result[idx] = hm.get(sortedStart[ridx]);
            }
        }

        return result;
    }
}