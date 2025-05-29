pakage my.com.app.iterateor;

import java.util.*;
// Compressed String Iterator

// Implement a data structure to iterate through a compressed string representation.
//Approach :   Ondemad calculation of next character based on the compressed string format.
// The compressed string is in the format of "a1b2c3" where 'a', 'b', 'c' are characters and '1', '2', '3' are their respective counts.
// The iterator should return the characters in the order they appear in the compressed string, and handle the counts correctly.
// contant runtime and space complexity of O(1) for next() and hasNext() methods.


class StringIterator {

    String str;
    char curr_char;
    int curr_count;
    int curr_index;
    public StringIterator(String compressedString) {
        
        str = compressedString;
        
        // if ( str.length() ==1) 
        
        curr_char = ' ';

        curr_count = 0;
        curr_index =0;
    }
    
    public char next() {
        
        if (!hasNext())
            return ' ';

        if ( curr_count == 0){
            // change to next
            curr_char = str.charAt(curr_index++);
            while ( curr_index < str.length() && Character.isDigit( str.charAt(curr_index) )){
                curr_count = curr_count*10 + (str.charAt(curr_index++) -'0');
            }
        }
        curr_count--;

        return curr_char;
    }
    
    public boolean hasNext() {
        return curr_index< str.length() || curr_count != 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */