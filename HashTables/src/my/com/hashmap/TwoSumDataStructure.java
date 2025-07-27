package my.com.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TwoSumDataStructure {
    
    //Map<Integer, Integer> hm;
    List<Integer> stream;
    boolean isSorted;
    public TwoSumDataStructure() {

        //hm  = new TreeMap<>();    
        stream = new ArrayList<>();
        isSorted = false;
    }
    
    public void add(int number) {

        //hm.put( number, hm.getOrDefault(number, 0 )+1);
        stream.add(number);
        isSorted = false;
    
    }
    
    public boolean find(int value) {
      /*  
        for (int i : hm.keySet()){
            if ( hm.containsKey( value - i)){
                if ( i == value-i && hm.get( i ) == 1){
                    return false;
                }

                return true;
            }
        }
        return false;
        */

        if ( !isSorted ){
            Collections.sort(stream);
        }
        
        int i =0 , j = stream.size()-1;
        while ( i< j) {
            if ( stream.get(i) + stream.get(j) == value ){
                return true;
            } else if (stream.get(i) + stream.get(j) < value ) {
                i++;
            } else {
                j--;
            }

        }

        return false;
    }
}
