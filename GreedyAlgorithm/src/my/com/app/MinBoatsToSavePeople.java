package my.com.app;

import java.util.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        // since all the weight of people are less than limit 
        // sort the array in ascending order , then take two lowest value sum less than equal to limit.
        if ( people.length == 1)
            return 1;

        Arrays.sort(people);

        int i=0, j =people.length-1, count =0;
        while ( i<=j ){
            if (people[i] + people[j] <= limit ){
                i++;
                j--;
                
            } else {
                j--;
            }
            count++;
        }
        
        return count;
    }
}