package my.com.hashmap ;

import java.util.*;

// approach

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
 
        if(strs.length == 0)
            return new ArrayList();
        
        Map<String, Integer> map  = new HashMap();
        
        List<List<String>> res = new ArrayList();
        
        for(String s : strs){
            char[] sorted = s.toCharArray(); 
            Arrays.sort(sorted);
            String key = String.valueOf(sorted);
            if(!map.containsKey(key)){
                map.put(key, res.size() );
                res.add(new ArrayList());
            }
                
            res.get( map.get(key)).add(s);
        }
            
        return res;
    }


    public List<List<String>> GroupByLetterCount(String[] strs) {

        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());

    }
    
}