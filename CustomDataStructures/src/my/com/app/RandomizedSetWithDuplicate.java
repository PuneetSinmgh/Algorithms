package src.my.com.app;

import java.util.*;
// approach : To keep all the elements in a list and maintain a hashmap to keep track of the indices of each element.
// This allows us to insert, remove and get random elements in average O(1) time
// The hashmap will map each element to a set of indices where that element is present in the list.
// This allows us to handle duplicates efficiently, as we can have multiple indices for the same element
// The getRandom method will return a random element from the list, which can be done in O(1) time by using a random index.
// The insert method will add the element to the list and update the hashmap with the new index of the element.
// The remove method will remove an element from the list and update the hashmap accordingly.
// If the element is not present in the hashmap, we return false.
// If the element is present, we remove one of its indices from the set in the hashmap, and if the set becomes empty, we remove the element from the hashmap as well.


class RandomizedCollection {
    
    HashMap<Integer, Set<Integer>> hm;
    List<Integer> l ;
    Random rand ;
    public RandomizedCollection() {
        hm = new HashMap();
        l = new ArrayList<Integer>();    
        rand = new Random();
    }
    
    public boolean insert(int val) {
        l.add(val);

        if ( hm.containsKey(val)){
            hm.get(val).add(l.size()-1);
            return hm.get(val).size() <= 1;  
        } 

        Set<Integer> idxSet =  new HashSet();
        idxSet.add(l.size()-1);
        hm.put(val , idxSet);
        
        return true;
    }
    
    public boolean remove(int val) {
        if (!hm.containsKey(val) || hm.get(val).size() == 0) 
            return false;

        if ( hm.containsKey(val) ){
            
            int i = hm.get(val).iterator().next();
            int last = l.get(l.size() - 1 );
            int lastidx = l.size() -1 ;

            hm.get(val).remove(i);
            
            // update the index of moved element
            l.set( i, last);

            hm.get(last).add(i);
            hm.get(last).remove(lastidx);
            
            l.remove( lastidx);
            return true;
        }

        return false;
    }
    
    public int getRandom() {
        return l.get( rand.nextInt(l.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */