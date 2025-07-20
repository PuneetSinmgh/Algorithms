package my.com.app.string;

import java.util.*;

public class WordBreak {
    
        public boolean wordBreak(String s, List<String> wordDict) {
     
        Boolean[] arr = new Boolean[s.length()];
        return helper(0, s ,wordDict,arr);
        
    }
    
    public boolean helper(int i, String s, List<String> wordDict, Boolean[] arr){
        
        if(i==s.length())
            return true;
        
        int j=0;
        
        if(arr[i]!=null)
            return arr[i];
        
        for(String str : wordDict){
            
            if(isequal(i , j , s, str)){
                
                if(helper(i+str.length(),s,wordDict,arr))
                    return arr[i] = true;
            }
            
        }
        
        return arr[i]=false;
    }
    
    public boolean isequal(int i, int j, String s, String str){
        if(j==str.length())
            return true;
            
        if(i== s.length())
            return false;
        
        if(s.charAt(i)==str.charAt(j))
            return isequal(++i,++j,s, str);
        else
            return false;
    }
}
