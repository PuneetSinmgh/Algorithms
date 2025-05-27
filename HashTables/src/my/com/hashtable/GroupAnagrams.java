package my.com.hashtable;

import java.util.*;
import java.lang.*;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		 
        if(strs.length == 0)
            return new ArrayList();
        int j ;
        char c;

        Map<String, List<String>> map  = new HashMap();
        List l;
        boolean flag =false;
        for(int i=0; i<strs.length; i++){         
            if(map.size()!=0){
                flag = false;    
                for(String s : map.keySet()){
                
                    if(containChars(s,strs[i])){
                        l=map.get(s);
                        l.add(strs[i]);
                        flag =true;
                    }    
                }
                if(!flag){
                        l = new ArrayList();
                        l.add(strs[i]);
                        map.put(strs[i],l);
                    }
            }
            else{
                l = new ArrayList();
                l.add(strs[i]);
                map.put(strs[i],l);
            }
        }
        
        List<List<String>> res  = new ArrayList();
        for(String s : map.keySet()){
            System.out.println(map.get(s));
            res.add(map.get(s));
        }
        
        return res;
    }
    
    boolean containChars(String s1,String s2){
        
        Map<Character, Integer> map = new HashMap();
        
        if(s1.length()!=s2.length())
            return false;
        
        for(int i=0; i<s1.length(); i++){
                map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        
        for(int j=0 ; j < s2.length(); j++){
            
            if(map.containsKey(s2.charAt(j))){
                map.put(s2.charAt(j),map.get(s2.charAt(j))-1);
            }
            else
                return false;
        }
        
        for(char c : map.keySet()){
            if(map.get(c)!=0)
                return false;
        }
        
        return true;
    }
    
}
