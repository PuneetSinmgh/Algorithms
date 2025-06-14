package src.my.com.app.slidingwindow;
// Approach: Use a sliding window with a HashMap to maintain the frequency of characters.
// The HashMap will help us efficiently track the number of distinct characters in the current substring.
// We will expand the right end of the window and contract the left end when the condition of having more than k distinct characters is violated.

import java.util.*;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap();

        int  i=0 , j =0;
        int res =0 ;
        while ( j <s.length() ){

            hm.put( s.charAt(j) , hm.getOrDefault( s.charAt(j), 0) +1 );

            while ( hm.size() > k ) { // if size is more than k , shrink substring until size is 2 or less than 2
                
                if ( hm.get( s.charAt(i) ) > 1 ){
                    hm.put( s.charAt(i), hm.get( s.charAt(i))-1) ;
                } else {
                    hm.remove(s.charAt(i)); 
                }

                i++;
            }

            res = Math.max( res , j-i+1 );
            j++;
        }

        return res;
    }
}