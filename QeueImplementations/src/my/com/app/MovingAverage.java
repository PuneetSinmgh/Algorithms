package my.com.app;

import java.util.*;

/*class ListNode {
    ListNode next;
    int val;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
class MovingAverage {

    ListNode head;
    ListNode tail;
    int win_size, que_size;
    double sum;

    public MovingAverage(int size) {
        this.win_size  = size;
        this.que_size = 0;
        this.head = null;
        this.tail = null;
        this.sum = 0.0;
    }
    
    public double next(int val) {
        ListNode n = new ListNode(val);
        // check if que is empty

        if ( que_size < win_size) {

            if ( que_size == 0){
                head = n;
                tail = n;
            } else {
                head.next = n;
                head = n; 
            }
            que_size++;
            sum += val;
        } else {
            // insert at head 
            head.next = n;
            head = n;
            sum += n.val;
            // remove from tail

            ListNode m = tail;
            tail = tail.next;
            m.next = null;
            sum -= m.val;
        }

    return sum/(double)que_size;
    }
}*/

class MovingAverage {
    
    LinkedList<Integer> ll;
    int size;
    double sum;
    public MovingAverage(int size) {

        ll = new LinkedList();
        this.size = size;
        sum = 0.0;

    }

    public double next(int val) {

        if ( ll.size() == this.size){    
            
            this.sum -= (double)ll.poll();
        }

        ll.offer(val);
        this.sum += (double)val; 

        return this.sum/(double)ll.size();
    }
}


/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

 