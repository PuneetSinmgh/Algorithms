package src.my.com.app;

import java.util.*;

// approach :
// 1. create a map of words and their indices
// 2. for each query, retrieve the indices of the two words
// 3. use two pointers to find the minimum distance between the indices of the two words
// 4. return the minimum distance found
// Time Complexity: O(n + m) where n is the number of words in the dictionary
// and m is the number of queries
// Space Complexity: O(n) for storing the indices of the words in the map

class WordDistance {

    HashMap<String , List<Integer>> idxMap;

    public WordDistance(String[] wordsDict) {
        idxMap = new HashMap();

        for (int i=0 ; i<wordsDict.length; i++){
            idxMap.computeIfAbsent(wordsDict[i], (v) ->  new ArrayList()).add(i);
        }    
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = idxMap.get(word1);
        List<Integer> l2 = idxMap.get(word2);

        int i =0, j =0;
        int minDist = Integer.MAX_VALUE;

        while ( i<l1.size() && j<l2.size()){
            int a = l1.get(i);
            int b = l2.get(j);
            minDist = Math.min( minDist, Math.abs(a - b));
            if ( a > b )
                j++;
            else
                i++;
        }
        return minDist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */