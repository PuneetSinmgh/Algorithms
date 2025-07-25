package my.com.hashtable;
import java.util.*;

// approach :
// 1. For each word in words2, calculate the frequency of each character and store the maximum frequency for each character.
// 2. For each word in words1, calculate the frequency of each character.
// 3. Check if the frequency of each character in the word from words1 is greater than or equal to the maximum frequency of that character from words2.
// 4. If it is, add the word from words1 to the result list.
// 	    return n;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<String> res = new ArrayList();
        int[] word2_max_freq = new int[26];
        Arrays.fill(word2_max_freq, 0);

        for(int i=0; i<words2.length; i++){
            HashMap<Character, Integer> hm = new HashMap();
            for ( char ch : words2[i].toCharArray()){
                hm.put( ch , hm.getOrDefault(ch, 0)+1 );
            }

            for ( char ch : hm.keySet()){
                
                word2_max_freq[ch-'a'] = Math.max( word2_max_freq[ch-'a'], hm.get(ch));  
                
            }
        }

        
        for (String s : words1) {
            int[] freq = new int[26];
            for (int i=0 ; i<s.length(); i++){
                freq[s.charAt(i) - 'a'] += 1;
            }   
            boolean add = true;
            for ( int j=0; j<26;j++ ){

                if ( word2_max_freq[j] > freq[j] ){
                    add = false;
                    break;
                }
                
            }
            if(add)
                res.add(s);
        }
        return res;
    }

} 