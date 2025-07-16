package my.com.bfs;
import java.util.*;


// Aliene Dictionary
// maintain inorder asd graph for all the given characters
// and then do a topological sort

class Solution {
    public String alienOrder(String[] words) {
        
        Map<Character,Set<Character>> gh = new HashMap();
        Map<Character,Integer> inorder = new HashMap();
        
        for(String s : words){
            for(char c : s.toCharArray()){
                gh.putIfAbsent(c,new HashSet());
                inorder.putIfAbsent(c,0);
            }
        }
        
        for(int i=1; i<words.length; i++){
 
            StringBuilder str = new StringBuilder();
            
                String s1 = words[i-1];
                String s2 = words[i];

                int j=0;
                
                if (s1.length() > s2.length() && s1.startsWith(s2)) {
                   return "";
                }
                
                while(j< Math.min(s1.length() ,s2.length())){
                    if(s1.charAt(j) != s2.charAt(j)){
                        if(!gh.get(s1.charAt(j)).contains(s2.charAt(j))){
                            gh.get(s1.charAt(j)).add(s2.charAt(j));
                            inorder.put(s2.charAt(j), inorder.get(s2.charAt(j))+1);
                        }
                        break;
                    }
                    j++;
                }
        }       
        
        Deque<Character> queue = new ArrayDeque<Character>();
        
        
        for(char c : inorder.keySet()){
            if(inorder.get(c) == 0){
                 queue.add(c);
            }
        }
 
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            
            char ch = queue.pop();
            sb.append(ch);
            
            Set<Character> l1 = gh.get(ch);
            for(char c : l1){
                inorder.put(c,inorder.get(c)-1);
                if(inorder.get(c) == 0){
                    queue.add(c);
                }
            }
        }
        
        
    if(sb.length() == inorder.size())
        return sb.toString();
    else
        return "";
        
     /*   Map<Character,List<Character>> gh = new HashMap();
        int[] visited = new int[26];
        Arrays.fill(visited,-1);
        for(int i=0; i<words.length; i++){
            
            for(int j=0; j<words[i].length();j++){
                if(!gh.containsKey(words[i].charAt(j))){
                    gh.put(words[i].charAt(j),new ArrayList());
                    visited[words[i].charAt(j) - 'a'] = 0;
                }
                    
            }
            if(i>0){
            
                
                String s1 = words[i-1];
                String s2 = words[i];

                int j=0 , len ;

                len  = Math.min(s1.length(), s2.length());

                while(j<len){

                        if(s1.charAt(j)!=s2.charAt(j)){
                            if(gh.containsKey(s1.charAt(j))){
                                List<Character> l = gh.get(s1.charAt(j));
                                l.add(s2.charAt(j));
                                gh.put(s1.charAt(j),l);
                            }
                            else{
                                List<Character> l = new ArrayList();
                                l.add(s2.charAt(j));
                                gh.put(s1.charAt(j),l);
                            }

                            break;
                        }
                        j++;

                }
            }
                
        }
        
        
        
        List<Character> letters = new ArrayList();
        for(char c : gh.keySet()){
           // visited[c - 'a'] = 0;
            letters.add(c);
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i=0 ;i<letters.size(); i++){
        
            if(visited[letters.get(i)-'a'] == 0){
                HashSet<Character> path = new HashSet();
                path.add(letters.get(i));
                if(!dfs(gh,visited,path,letters.get(i),sb))
                    return "";
            } 
        }
        
    
        return sb.reverse().toString();
    }    
    public boolean dfs(Map<Character, List<Character>> gh,int[] visited,HashSet<Character> path, char c, StringBuilder sb ){
        
        if(gh.containsKey(c)){
        
            for(char ch : gh.get(c)){
            
                if(path.contains(ch))
                    return false;
            
                if(visited[ch -'a'] == 0){
                    path.add(ch);
                    if(!dfs(gh,visited,path,ch,sb))
                        return false;
                    
                }
            
            }
        }
        
        path.remove(c);
        visited[c -'a'] = 1;
        sb.append(c);
        
        return true;*/
    }
        
}