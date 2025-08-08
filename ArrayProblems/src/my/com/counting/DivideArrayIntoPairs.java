package my.com.counting;

import java.util.*;
import java.util.stream.*;


class DivideArrayIntoPairs {
    public boolean divideArray(int[] nums) {
        // n pairs means each element has count == 2 else not possible
        // with using extra space
        Map<Integer, Long> hm = Arrays.stream(nums).boxed()
                .collect( Collectors.groupingBy( n -> n, Collectors.counting())) ;

        for ( long l : hm.values()){
            if ( l % 2 != 0)
                return false;
        }
        return true;

        // without using extra space :
        // sort the array , then run two pointers and count occurance of each element if the count is odd return false
    }
}