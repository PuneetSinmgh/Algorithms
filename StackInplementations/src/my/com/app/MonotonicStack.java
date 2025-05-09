package my.com.app;
import java.util.*;

// Problem: Daily Temperatures
// Decreasing order of temperatures
// 1. Create a stack to maintain the temperatures
// 2. Iterate through the temperatures array from the end to the beginning
// 3. If the current temperature is less than the top of the stack, push it onto the stack
// 4. If the current temperature is greater than the top of the stack, pop elements from the stack until you find a temperature that is greater than the current temperature
// 5. If the stack is empty, it means there are no higher temperatures in the future, so set the result to 0
// 6. If the stack is not empty, calculate the difference between the current index and the index of the top element in the stack
// 7. Push the current temperature onto the stack
// 8. Return the result array
// 9. Time complexity is O(n) and space complexity is O(n)
// 10. This is a monotonic stack problem


class Node{
    int val;
    int idx;

    Node(int val , int idx){
        this.val = val;
        this.idx = idx;
    }
}
class Solution {
    // maintain a min stack
    // compare the top value with the current value in temperatures , if value is less than tiop value , push onto the stack.
    // if value is higher , keep poping until higher value is found, compare the index , add to result and push the val on to stack.
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Node> stack = new Stack();

        int[] res = new int[temperatures.length];

        for (int i = temperatures.length-1; i>=0; i--){
            
            while (!stack.empty() && temperatures[i] >= stack.peek().val){
                stack.pop();
            }

            // compare with the top of stack, if stack value 
            res[i] = stack.empty() ? 0 : stack.peek().idx - i ;
            stack.push(new Node(temperatures[i], i));

        }
        
        return res;
    }
}