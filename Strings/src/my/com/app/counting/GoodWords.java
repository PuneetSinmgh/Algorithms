package my.com.app.counting;

import java.util.Arrays;

public class GoodWords {
    // This method counts the total length of all good words that can be formed
    // using the characters from the given string 'chars'.
    // A good word is defined as a word that can be formed using the characters
    // in 'chars' without exceeding the count of any character in 'chars'.
    // The method returns the total length of all such good words.
    // The input 'words' is an array of strings representing the words to be checked.
    // The input 'chars' is a string representing the available characters.
    
    // Time Complexity: O(n * m) where n is the number of words and m is the average length of the words.
    // Space Complexity: O(1) if we do

    public int countCharacters(String[] words, String chars) {
        
        if(words.length == 0 || chars.length()==0)
            return 0;
        
        boolean rej;
        int res =0 ;
        
        int[] charCounts = new int[26];

        for(char c : chars.toCharArray()){
            charCounts[c - 'a']++;
        }
        
        int[] arr = new int[26];
        for(String s : words){
            rej = false;
            
            Arrays.fill(arr,0);
            
            for(char c : s.toCharArray()){
                arr[c - 'a']++;
            }
            
            for ( int i=0 ;i <26; i++){
                if ( charCounts[i] < arr[i]){
                    rej = true;
                    break;
                }
            }
            if(!rej){
                res += s.length();
            }
            
        }
        
        return res;
    }
}
