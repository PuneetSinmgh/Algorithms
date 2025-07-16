package my.com.app.stack;
import java.util.*;

class Solution {
    public String removeStars(String s) {

        StringBuilder sb = new StringBuilder();

        for ( int i =0 ; i <s.length(); i++){
            
            if ( s.charAt(i) != '*'){
                sb.append(s.charAt(i));
            } else {
                if ( sb.length() > 0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }

        return sb.length() > 0 ? sb.toString() : "";
    }
}