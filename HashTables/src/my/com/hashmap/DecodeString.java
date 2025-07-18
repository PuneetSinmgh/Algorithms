package my.com.hashmap;

import java.util.*;

// Problem Decode String
// Given a key and a message, decode the message using the key.

public class DecodeString {
    public String decodeMessage(String key, String message) {
        
        HashMap<Character, Character> hm = new HashMap();
        
        char cp = 'a';
        for ( char c : key.toCharArray()){
            if (!hm.containsKey(c) && hm.size()<26 && c!=' '){
                hm.put( c ,  cp );
                cp= (char)(cp+1);
            }
        }

        
        char[] msgArr = message.toCharArray();
        for ( int i=0; i< msgArr.length; i++ ){
            
            if ( msgArr[i] != ' '){
                msgArr[i] = hm.get(msgArr[i]);
            }
        }

        return new String(msgArr);
    }
}