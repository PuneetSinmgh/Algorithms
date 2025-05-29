package my.com.app;

import java.util.*;

// approach:
// 1. Create a queue to store the pointers to the next element in each vector. Only vectors with size more than 1 are added to the queue.
//    Each pointer is a pair of integers: (vector index, element index).
//    This allows us to keep track of which vector and which element we are currently accessing.
//    The queue will help us alternate between the vectors when calling next().
// 2. Use a pair to store the vector index and the element index.




public class ZigzagIterator {

    private List<List<Integer>> vectors = new ArrayList<>();
    private LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.vectors.add(v1);
        this.vectors.add(v2);
        int index = 0;
        for (List<Integer> vec : this.vectors) {
            if (vec.size() > 0)
                this.queue.add(new Pair<Integer, Integer>(index, 0)); // vextors with size more than 1 are added to queue.
            index++;
        }
    }

    public int next() {
        
        Pair<Integer, Integer> pointer = this.queue.removeFirst();
        
        Integer vecIndex = pointer.getKey();
        Integer elemIndex = pointer.getValue();
        
        Integer nextElemIndex = elemIndex + 1;
        // append the pointer for the next round
        // if there are some elements left.
        if (nextElemIndex < this.vectors.get(vecIndex).size())
            this.queue.addLast(new Pair<>(vecIndex, nextElemIndex));

        return this.vectors.get(vecIndex).get(elemIndex);
    }

    public boolean hasNext() {
        return this.queue.size() > 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */