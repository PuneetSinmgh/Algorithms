package src.my.com.app;

import java.util.*;

class RandomizedSet {

    HashMap<Integer, Integer> hm ; // to store the value and its index in the list
    // we use a list to store the elements, so that we can get a random element
    // and also to remove an element in constant time
    // the index of the element in the list is stored in the hashmap
    ArrayList<Integer> ls;
    Random rand = new Random();
    
    public RandomizedSet() {
        hm = new HashMap();
        ls = new ArrayList();
    }
    
    public boolean insert(int val) {
        // return true , if value not present and insert into set

        if(hm.containsKey(val)){
            return false;
        }

        hm.put(val, ls.size()); 
        ls.add(ls.size(),val);

        return true;
    }
    // for constant run time  : removing an element from list will need index of the elelment, HM is used to map the index of the elements present in the list;
    public boolean remove(int val) {
       // remove the element if present and return true, false itherwise 
       if(hm.containsKey(val)){
            
            int last = ls.get(ls.size()-1); // get the last element
            int idx = hm.get(val); // get the index of element to remove
            ls.set(idx, last);  // set last element on index to remove
            hm.put(last, idx);  // update the last element index mapping
            
            ls.remove(ls.size()-1);  // remove the last index
            hm.remove(val); // remove the val from HM
            
            return true;
        }

        return false;
    }
    
    public int getRandom() {
        
        return ls.get( rand.nextInt(ls.size()) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */