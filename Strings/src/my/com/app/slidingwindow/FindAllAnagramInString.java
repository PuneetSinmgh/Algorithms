package my.com.app.slidingwindow;

import java.util.*;

// Approach: Sliding Window Technique
// Time Complexity: O(n)
// Space Complexity: O(1) for the count arrays
// Explanation: We maintain a sliding window of size equal to the length of p. We count the frequency of characters in both the current window of s and in p. If the two frequency arrays are equal, it means the current window is an anagram of p, and we add the starting



class Solution {
    public List<Integer> findAnagrams(String s, String p) {

    /* 
        if(s.length() ==0 || s.length() < p.length())
            return new ArrayList();
        
        int m = p.length();
        List<Integer> res = new ArrayList();
        for(int i=0 ; i<=(s.length() - m); i++ ){
            
            if(validAnagram(s.substring(i,i+m) ,p)){
                res.add(i);
            }
        }
        
        return res;
    }
    
    public boolean validAnagram(String s , String t ){
        if(s.length()!= t.length())
            return false;
        
        int[] temparr = new int[26];
        
        for(int i=0 ;i<s.length(); i++){
            
            temparr[s.charAt(i) - 'a']++;
            
            temparr[t.charAt(i) - 'a']--;
            
        }
        
        for(int i=0; i<temparr.length; i++){
            if(temparr[i] != 0)
                return false;
        }
        
        return true; */
        
        if(s.length() ==0 || s.length() < p.length())
            return new ArrayList();
        
        
        List<Integer> res = new ArrayList();

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for ( int i=0; i <p.length(); i++){
            pCount[ p.charAt(i) - 'a']++;
        }
        
        int win_size = p.length() ;

        for ( int i=0 ; i < s.length() ; i++){
            
            sCount[ s.charAt(i) - 'a']++;
            

            if (i >= win_size){
                sCount[ s.charAt(i-win_size) - 'a']--;
            }
            
            if( Arrays.equals( sCount , pCount))
                res.add(i-win_size+1);

        }

        return res;

    } 
}