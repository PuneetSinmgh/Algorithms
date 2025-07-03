package src.my.com.app;

import java.util.*;

class MaxStack {

    TreeSet<int[]> stack;
    TreeSet<int[]> values;
    int ctx;

    public MaxStack() {
        Comparator<int[]> comp = (a, b) -> {
            return a[0] == b[0]? a[1] - b[1] : a[0] - b[0] ;
        };
        stack = new TreeSet( comp );
        values = new TreeSet( comp );
        ctx =0;
    }
    
    public void push(int x) {
        stack.add( new int[]{ctx, x});
        values.add( new int[]{x , ctx});
        ctx++;
    }
    
    public int pop() {
        int[] top = stack.pollLast();
        values.remove(new int[] {top[1], top[0]});
        return top[1];
    }
    
    public int top() {
        return stack.last()[1];
    }
    
    public int peekMax() {
        return values.last()[0];
    }
    
    public int popMax() {
        int[] maxVal = values.pollLast();
        stack.remove(new int[] {maxVal[1], maxVal[0]});
        return maxVal[0];
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */