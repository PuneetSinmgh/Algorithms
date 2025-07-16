package my.com.app;

import java.util.*;
// Interval Intersection
// Given two lists of intervals, find the intersection of these two lists.
// approach : 
// - use two pointers to traverse both lists
// - for each pair of intervals, check if they overlap
// - if they do, add the intersection to the result list
// - move the pointer of the interval that ends first
// - continue until one of the lists is fully traversed

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        if (firstList.length == 0 ||  secondList.length == 0 )
            return new int[0][];

        List<int[]> res = new ArrayList();
        
        int i =0 , j=0;
        while( i<firstList.length && j<secondList.length ){
            
            int low =0  , high=0;
            low = Math.max (firstList[i][0], secondList[j][0]) ; //secondList[j][0];
            high  =  Math.min( secondList[j][1], firstList[i][1]);

        /*    if ( firstList[i][0] <= secondList[j][0] && firstList[i][1] >= secondList[j][0]){
                low = Math.max (firstList[i][0], secondList[j][0]) ; //secondList[j][0];
                high  =  Math.min( secondList[j][1], firstList[i][1]);

            } else if ( firstList[i][0] <= secondList[j][1] && firstList[i][1] >= secondList[j][1] ) {
                
                low =  Math.max (firstList[i][0], secondList[j][0]) ;
                high  = secondList[j][1];
            }
        */
            if (low <= high )
                res.add( new int[]{low, high});
            
            if ( firstList[i][1] < secondList[j][1]){
                i++;
            } else {
                j++;
            }
        }
       return res.toArray(new int[res.size()][]);
    }
}