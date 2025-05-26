package my.com.stack;
import java.util.*;
// Basic Calculator II
// Implement a basic calculator to evaluate a simple expression string containing non-negative integers, '+', '-', '*', and '/' operators.

// approach: Use a stack to evaluate the expression based on the order of operations.
// The idea is to iterate through the string, build numbers, and apply operations based on the previous operator.
// The time complexity is O(n) where n is the length of the string, as each character is processed once.    
class Solution {
    public int calculate(String s) {
        
        // there is order of operation " + , - , *, /"
        
        Stack<Integer> stack = new Stack();
        int currNum = 0;
        char op = '+'; // represents previous operation

        for ( int i=0; i < s.length(); i++){
        
            char ch = s.charAt(i);
        
            if ( Character.isDigit(ch)){
        
                currNum = (currNum * 10) + ( Character.getNumericValue(ch)) ;
        
            } 

            if ( (!Character.isDigit(ch) && !Character.isWhitespace(ch))  || i == s.length()-1) {

                if ( op == '*' || op == '/'){ // if current character is an operand , evaluate previous opreation
                
                    int a  = stack.pop();
                    
                    int b = currNum ;
                    int res;
                    if ( op == '*'){
                        res = a * b;
                    } else {
                        res = a / b;
                    }

                    stack.push(res);
                    
                } else if ( op == '+' ) {
                    
                    stack.push( currNum );
                
                } else if ( op == '-' ) {
                    
                    stack.push( -currNum ); 

                }

                op = ch;
                currNum = 0;
            }
        }  

        int res = 0; 
        while(stack.size()!=0){
            res += stack.pop(); // add all the results from stack
        }

        return res;
    }
}