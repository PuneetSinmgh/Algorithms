package src.my.com.app;
import java.util.*;
import javafx.util.Pair;
// Time Based Key-Value Store
// Approach: Use a HashMap to store the key-value pairs along with their timestamps.
// For each key, maintain a list of pairs (timestamp, value). When setting a value, add it to the list.
// When getting a value, perform a binary search on the list to find the highest timestamp less than or equal to the given timestamp.
// This allows for efficient retrieval of the value associated with a key at a specific timestamp.


class TimeMap {

    HashMap<String, ArrayList<Pair<Integer, String>>> hm ;

    public TimeMap() {
        this.hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)){
            hm.put(key, new ArrayList());
        }

        hm.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        
        if(!hm.containsKey(key)) return "";

        if ( hm.get(key).get(0).getKey()> timestamp) return "";

        // run binary seacrch to find the correct index for highest timestamp less than given timestamp
        List<Pair<Integer, String>> l = hm.get(key);
        int s=0, e=l.size()-1;
        while (s<=e){

            int m = s+ (e-s)/2;
            if ( l.get(m).getKey() > timestamp ) 
                e = m-1;
            else if ( l.get(m).getKey() < timestamp )
                s = m+1;
            else
                return l.get(m).getValue();
        }

        return l.get(e).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */