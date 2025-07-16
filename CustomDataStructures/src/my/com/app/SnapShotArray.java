package my.com.app;

import java.util.*;

// Snapshot Array : 

/* Simple implementation of a snapshot array that allows setting values at indices, taking snapshots, and retrieving values from specific snapshots.
 * This implementation uses a list of lists to store the snapshots, where each snapshot is a copy of the current state of the array.
 * This implementation takes lot of space and time, but it is simple and easy to understand.
    * Time Complexity: 
    * - set: O(1)
    * - snap: O(n) where n is the length of the array (due to copying the array)
    * - get: O(1)
    * Space Complexity: O(n * s) where n is the length of the array and s is the number of snapshots taken (due to storing each snapshot as a separate list).
    * This implementation is not optimal for large arrays or many snapshots, but it is a good starting point for understanding the concept of snapshot arrays.
    * This implementation can be improved by using a more efficient data structure to store the snapshots, such as a

    class SnapshotArray {

    List<List<Integer>> snapshots;
    int[] temp;

    public SnapshotArray(int length) {

        snapshots = new ArrayList();
        temp = new int[length];
    }
    
    public void set(int index, int val) {
        temp[index] = val;
    }
    
    public int snap() {
        snapshots.add(new ArrayList<Integer>( Arrays.stream(temp).boxed().toList() ));
        return snapshots.size()-1;
    }
    
    public int get(int index, int snap_id) {
        
        return snapshots.get(snap_id).get(index);
    
    }
}
*/

// TreeMap to store the snapshots, where the key is the snap_id and the value is the value at that index at that snapshot.
// This implementation is more space and time efficient than the previous one, as it only stores the values that have been set at each index for each snapshot.
// Time Complexity:
// - set: O(log s) where s is the number of snapshots (due to TreeMap operations)
// - snap: O(1)
// - get: O(log s) where s is the number of snapshots (due to TreeMap operations)
// Space Complexity: O(n * s) where n is the length of the array and s is the number of snapshots taken (due to storing each snapshot as a TreeMap).
// This implementation is more efficient than the previous one, as it only stores the values that have been set at each index for each snapshot, rather than storing the entire array for each snapshot.
// This allows for more efficient memory usage, especially when the array is large and only a few values are set at each index

import java.util.TreeMap;

class SnapshotArray {

    TreeMap<Integer, Integer>[] snapshots;
    int snapId;

    public SnapshotArray(int length) {

        snapshots = new TreeMap[length];
        for (int i=0; i<length; i++){
            snapshots[i] = new TreeMap<Integer, Integer>();
        }
        snapId = 0;
    }
    
    public void set(int index, int val) {
    
        snapshots[index].put(snapId, val);
        
    }
    
    public int snap() {
        int currId = snapId;
        snapId++;
        return currId;
    }
    
    public int get(int index, int snap_id) {
        
        if(snapshots[index].floorEntry(snap_id) == null)
            return 0;
        else
            return snapshots[index].floorEntry(snap_id).getValue();   
    }
}