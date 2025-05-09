package my.com.app;
import java.util.*;

/// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
// Implement the MinStack class:
// 1. MinStack() initializes the stack object.  
// 2. void push(int val) pushes the element val onto the stack.


class StackNode {
    int val;
    int minval;

    StackNode(int val , int min) {
        this.val = val ;
        this.minval = min;
    }
}

class MinStack {

    LinkedList<StackNode> stack ;


    public MinStack() {
        stack = new LinkedList();
    }
    
    public void push(int val) {

        if ( stack.size() == 0 ){
            stack.add( new StackNode(val , val));
        } else {
            int em = stack.peekLast().minval;
            if ( val < em ){
                stack.add( new StackNode(val , val));
            } else {
                stack.add( new StackNode(val , em ));
            }
        }
    }
    
    public void pop() {
        stack.removeLast();
    }
    
    public int top() {
        return stack.peekLast().val;
    }
    
    public int getMin() {
        return stack.peekLast().minval;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */