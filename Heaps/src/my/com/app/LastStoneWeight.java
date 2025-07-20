package my.com.app;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    // Approach: Use a max heap to store the stones.
    // The largest two stones are removed from the heap, and if they are not equal,
    // the difference is added back to the heap.
    // This process continues until there is one or no stones left.
    // If there is one stone left, return its weight; otherwise, return 0.

    // Time Complexity: O(n log n) where n is the number of stones.
    // Space Complexity: O(n) for the priority queue.
    public int lastStoneWeight(int[] stones) {
        // first sort the array in descending order
        if ( stones.length == 1)
            return stones[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //Arrays.sort(stones.stream().map(Integer), Collections.reverseOrder());

        // loop over the array add into PriorityQueue
        for ( int i : stones){
            pq.add(i);
        }

        while ( pq.size() > 1){
           int y = pq.poll();
           int x = pq.poll();
           
           if ( x != y){
                pq.add(y-x);
           }
        }

        return pq.size()==1? pq.poll() : 0 ;
    }
}
