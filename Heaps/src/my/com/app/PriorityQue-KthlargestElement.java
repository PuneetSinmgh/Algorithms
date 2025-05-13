package my.com.app;

import java.util.*;


// Design a class which finds Kth Largest Element in a Stream
// Implement the KthLargest class:
// Use a min heap to keep track of the K largest elements
// KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
// The stream initially contains all elements of nums.
// KthLargest.add(int val) appends the integer val to the stream and returns the element representing the kth largest element in the stream.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// It can be assumed that there will always be at least k elements in the stream when calling each KthLargest.add method.

class KthLargest {

    PriorityQueue<Integer> que ;
    int realSize;
    public KthLargest(int k, int[] nums) {
        realSize = k;
        this.que = new PriorityQueue<Integer>(k);
        for (int i =0; i < nums.length; i++ ){
            if(que.size() == k){
                if (nums[i] > que.peek()){
                    que.poll();
                    que.add(nums[i]);
                }
            } else {
                que.add(nums[i]);
            }

        }
    }
    
    public int add(int val) {

        if(que.size() == realSize){
            if (val > que.peek()){
                que.poll();
                que.add(val);
            }
        } else {
            que.add(val);
        }
        return que.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */