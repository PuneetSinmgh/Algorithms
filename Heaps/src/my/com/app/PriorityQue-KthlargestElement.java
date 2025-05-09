package my.com.app;

import java.util.*;


// Design a class whihc finds Kth Largest Element in a Stream
// 
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