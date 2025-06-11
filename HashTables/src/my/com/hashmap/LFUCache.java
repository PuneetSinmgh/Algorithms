package src.my.com.hashmap;
import javafx.util.Pair;
import java.util.*;
// LFU Cache implementation
// LFU Cache is a cache that evicts the least frequently used items first
// It maintains a mapping of keys to values and their frequencies

//  approach : Maintain a hashmap to store the key and its value and frequency
// Use a second hashmap to maintain the frequency and the set of keys with that frequency
// When a key is accessed, update its frequency and move it to the next frequency set
// When a key is added, if the cache is full, remove the least frequently used key
// If the frequency set becomes empty, remove the frequency from the hashmap
// Use a min frequency variable to keep track of the minimum frequency in the cache 

class LFUCache {

    HashMap<Integer, Pair <Integer, Integer>> cache ; // this stores Key , ( value , freq)
    HashMap<Integer, LinkedHashSet<Integer>> frequencies; // LinkedHashMap can be used 
    int minf;
    int capacity; 
    
    public LFUCache(int capacity) {
        cache = new HashMap(capacity);
        frequencies = new HashMap();
        minf = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // get will fetch key value from hmKV and update frequency
        Pair<Integer, Integer> frequencyAndValue = cache.get(key);
        if (frequencyAndValue == null) {
            return -1;
        }
        final int frequency = frequencyAndValue.getKey();
        final Set<Integer> keys = frequencies.get(frequency);
        keys.remove(key);
        if (keys.isEmpty()) {
            frequencies.remove(frequency);

            if (minf == frequency) {
                ++minf;
            }
        }
        final int value = frequencyAndValue.getValue();
        insert(key, frequency + 1, value);
        return value;
        
    }

    private void insert(int key, int frequency, int value) {
        cache.put(key, new Pair<>(frequency, value));
        frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
        frequencies.get(frequency).add(key);
    }
    
    public void put(int key, int value) {
        // check if capacity is less than 0
        if (capacity <= 0) {
            return;
        }

        Pair<Integer, Integer> frequencyAndValue = cache.get(key);
        if (frequencyAndValue != null) {
            cache.put(key, new Pair<>(frequencyAndValue.getKey(), value));
            get(key);
            return;
        }

        // check if cache size is full, remove min frequency, if mapped set becomes zero then remove the freq to set mapping
        if (capacity == cache.size()) {
            final Set<Integer> keys = frequencies.get(minf);
            final int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
            if (keys.isEmpty()) {
                frequencies.remove(minf);
            }
        }

        minf = 1;
        insert(key, 1, value);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */