package my.com.app;


import java.util.*;


public class LPSBruteforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	


	class Solution {
	    List<String> l = new ArrayList();
	    public String longestPalindrome(String s) {
	        
	        if(s.length() == 0) 
	            return "";
	        
	        if(s==null)
	            return null;
	        
	        if(s.length() == 1)
	            return s;
	        lcp(s,0 , s.length()-1,Integer.MIN_VALUE,new String(), l);
	                
	        if(l.size()==0)
	            return s.substring(0,1);
	        String smax = new String();
	        int len = Integer.MIN_VALUE;
	        for(String st : l){
	            if(st.length()>=len){
	                len = st.length();
	                smax = st;
	            }
	        }
	        return smax;
	    }
	    
	    public int lcp(String s , int start , int last, int maxlen, String ps, List<String> l ){
	        
	        if(start == last)
	            return 1;
	        if(start>last)
	            return 0;
	        int c1=0;
	        if(s.charAt(start)==s.charAt(last)){
	            int remlen = last-start-1;
	            if(remlen == lcp(s,start+1,last-1, maxlen, ps,l)){
	                
	                String str = s.substring(start,last+1);
	                
	                if(str.length()>=maxlen){
	                    maxlen = str.length();
	                    ps=str;
	                    l.add(ps);
	                }
	                
	              c1 = remlen+2;  
	            }
	        }
	        
	        int c2 = lcp(s ,start+1,last, maxlen, ps,l);
	        int c3 =lcp(s ,start,last-1, maxlen, ps,l);
	        
	        return Math.max(c1,Math.max(c2,c3));
	    }
	}
	
public int lcp(String s , int start , int last, int maxlen, String ps, List<String> l, int[][] lookup ){
        
        if(start == last)
            return 1;
        if(start>last)
            return 0;
        int c1=0;
        
        if(lookup[start][last] == 0){
        
            
                if(s.charAt(start)==s.charAt(last)){
                int remlen = last-start-1;
                    if(lookup[start+1][last-1]==0){
             
                       if(remlen == lcp(s,start+1,last-1, maxlen, ps,l,lookup)){
                
                        String str = s.substring(start,last+1);
                
                          if(str.length()>=maxlen){
                            maxlen = str.length();
                            ps=str;
                            l.add(ps);
                          }
                
                        c1 = remlen+2;  
                        }
                    }
                    else{
                        if(remlen == lookup[start+1][last-1]){
                
                        String str = s.substring(start,last+1);
                
                            if(str.length()>=maxlen){
                                maxlen = str.length();
                                ps=str;
                                l.add(ps);
                            }
                
                        c1 = remlen+2;  
                    }
                }
            }
        
            int c2 = lcp(s ,start+1,last, maxlen, ps,l, lookup);
            int c3 =lcp(s ,start,last-1, maxlen, ps,l,lookup);
        
            lookup[start][last] = Math.max(c1,Math.max(c2,c3));
        }
        
        return lookup[start][last];
    }
	
}
