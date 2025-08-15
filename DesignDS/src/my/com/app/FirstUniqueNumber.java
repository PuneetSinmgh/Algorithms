package my.com.app;

import java.util.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstUniqueNumber {
    
    Set<Integer> uniqueset ;
    Set<Integer> uniqueOrder;

    public FirstUniqueNumber(int[] nums) {
        
        uniqueset = new HashSet(); // set to track all the elements entered in queue

        uniqueOrder = new LinkedHashSet(); // linked hashset to track unique elements in order
        
        for ( int i=0 ;i < nums.length; i++){
            
            if ( !uniqueset.contains( nums[i]) ){
                // add only unique elements
                uniqueOrder.add(nums[i]);
                uniqueset.add(nums[i]);
                
            } else {

                uniqueOrder.remove(nums[i]); // runtime constant
                
                
            }
            
        
        }
    }
    
    public int showFirstUnique() {
        if (!uniqueOrder.isEmpty()){
            
            return uniqueOrder.iterator().next();
        }
            
        return -1;    
    }
    
    public void add(int value) {
        
        if ( !uniqueset.contains( value )){
            uniqueOrder.add(value);
            uniqueset.add(value);
        
        } else {

            // remove already existing elements
            uniqueOrder.remove(value); // runtime constant
            //uniqueset.remove(value);
            
        }
        
        
    }
}
