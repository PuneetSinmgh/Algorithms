package my.com.hashmap;

import java.util.Map;
import java.util.TreeMap;

public class TwoSumDataStructure {
    
     Map<Integer, Integer> hm;
    
    public TwoSumDataStructure() {

        hm  = new TreeMap<>();    
    
    }
    
    public void add(int number) {

        hm.put( number, hm.getOrDefault(number, 0 )+1);
    
    }
    
    public boolean find(int value) {
        
        for (int i : hm.keySet()){
            if ( hm.containsKey( value - i)){
                if ( i == value-i && hm.get( i ) == 1){
                    return false;
                }

                return true;
            }
        }
        return false;
    }
}
