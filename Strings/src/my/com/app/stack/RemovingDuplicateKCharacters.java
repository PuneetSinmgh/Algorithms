package my.com.app.stack;

import java.util.*;

import java.util.stream.Collectors;
// This code removes adjacent duplicates from a string where the count of duplicates is equal to k.
// The approach uses a stack to keep track of characters and their current counts.
// If the count of a character reaches k, all occurrences of that character are removed from the stack.
// The final result is constructed from the characters remaining in the stack.
// The time complexity is O(n) where n is the length of the string, as each character is processed once.
// The space complexity is O(n) in the worst case, where all characters are unique and stored in the stack.

class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<int[]> stack = new Stack();

        for ( int i=0; i < s.length(); i++){
            
            if ( stack.size() > 0) {
                
                if ( s.charAt(i) != stack.peek()[0] ){
                    
                    stack.push(new int[]{ s.charAt(i), 1});
 
                } else {

                    if ( stack.peek()[1]+1 == k){ // if count for current char becomes k, then remove all existing char from stack
                        
                        while( stack.size()>0 && stack.peek()[0] == s.charAt(i)){
                            stack.pop(); // delete all chars from stack if. count equals k.
                        }
                    } else {

                        stack.push(new int[]{ s.charAt(i), stack.peek()[1]+1}); // if count is less than k push onto the stack
                    
                    }
                }

            } else {
                // if stack is empty , add on to the stack and increase by 1;
                stack.push(new int[]{ s.charAt(i), 1});
               
            }
        }
        if ( stack.size() == 0)
            return "";

       return stack.stream().map( a -> Character.toString(a[0]) ).collect(Collectors.joining());
    }
}