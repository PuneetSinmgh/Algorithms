package src.my.com.app.stringslicing;
import java.util.*;
// Goat Latin Transform

//Approach : split the sentence into words, check the first character of each word, and apply the rules for Goat Latin transformation.

class Solution {
    public String toGoatLatin(String sentence) {
        
        // split the sentence 
        // track no a in a string
        // loop over each word in the sentence and add suffix accordingly

        String[] strs = sentence.split(" ");
        StringBuilder res = new StringBuilder();

        String suffix = "";
        StringBuilder curr = new StringBuilder();

        for( int i=0 ; i<strs.length; i++) {
            char ch = Character.toLowerCase( strs[i].charAt(0) );
            
            curr = new StringBuilder(strs[i]);
            
            if ( ch == 'a' ||  ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                // then add suffix
                suffix += "a";
                curr.append("ma").append(suffix);    
            } else {
                // remove the first then add to end
                curr.deleteCharAt(0);
                curr.append(strs[i].charAt(0));
                suffix += "a";
                curr.append("ma").append(suffix);
            }

            if( i != strs.length-1){
                res.append(curr);
                res.append(" ");
            }
        }

        res.append(curr);
        return res.toString();
    }
}