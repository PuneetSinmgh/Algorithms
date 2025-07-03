package src.my.com.app;
import java.util.*;


// approach : use stack to keep track of opening paranthesis
// when we encounter closing paranthesis, check if the top of stack is matching opening paranthesis
// if it is, pop the stack, else return false
// at the end, if stack is empty, return true, else false       

// Time Complexity: O(n) where n is the length of the string
// Space Complexity: O(n) in the worst case, when all characters are opening parantheses
class Solution {
    public boolean isValid(String s) {
     
        if(s.length()==0 || s.length()==1)
            return false;
        
        Stack<Character> st = new Stack();
        char ch;
        for(char c : s.toCharArray()){
            
            if(c == '(' || c == '{' || c== '['){
                
                st.push(c);
            }else if(c == ')' || c == '}' || c== ']'){
                if(!st.isEmpty()){
                    ch = st.pop();
                    if(c ==')' && ch != '(')
                        return false;
                    else if(c =='}' && ch != '{')
                        return false;
                    else if(c ==']' && ch != '[')
                        return false;
                }else
                    return false;
                
            }
            
        }

        return st.isEmpty();
    }
}