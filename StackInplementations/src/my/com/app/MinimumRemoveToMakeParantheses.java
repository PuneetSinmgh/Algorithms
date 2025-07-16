package my.com.app;

import java.util.*;

// approach:
// 1. Use a stack to keep track of the indices of unmatched '(' characters. 
// 2. Traverse the string and for each character:
//    - If it's '(', push its index onto the stack.
//    - If it's ')', check if the stack is not empty (indicating a matching '(' exists). If it is, pop the stack; otherwise, record the index of the unmatched ') character.
// 3. After processing the string, if there are any indices left in the stack,
//    they correspond to unmatched '(' characters. Add these indices to the list of indices to remove.
// 4. Sort the list of indices to remove in descending order and remove characters from the string
//    at these indices to form the final valid string.  

// time complexity: O(n log n) due to sorting the indices to remove
// space complexity: O(n) for the stack and list of indices to remove

class Solution {
    public String minRemoveToMakeValid(String s) {
        
        if (s.length()==0)
            return s;
        
        Stack<Integer> st = new Stack();
        Set<Integer> l = new HashSet();
        
        for(int i=0 ; i <s.length(); i++){
            if(s.charAt(i)=='(')
                st.push(i);
            
            else if(s.charAt(i)==')'){
             
                if(!st.isEmpty()){
                    st.pop();
                }else{
                    l.add(i);
                }
            }
        }
        if(!st.isEmpty()){
            while(!st.isEmpty()){
                l.add(st.pop());
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
    
        for(int i=0; i< s.length(); i++ ){
            if ( !l.contains(i))
                sb.append(s.charAt(i));
        }
    
                
        return new String(sb);
    }
}