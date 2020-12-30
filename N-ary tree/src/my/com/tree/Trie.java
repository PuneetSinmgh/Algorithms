package my.com.tree;
import java.lang.*;
import java.util.*;



public class Trie {

    private TrieNode root;   
    
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode('/');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        
        for(char ch  : word.toCharArray()){
            
            TrieNode n = new TrieNode(ch);
            
            if(cur.children.get(ch) ==null){
                cur.children.put(ch,n);
            }   
            
            cur = cur.children.get(ch);
            
        }    
        
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        
        for(char ch : word.toCharArray()){
            
            if(cur.children.get(ch) == null)
                return false;
            
            cur = cur.children.get(ch);
        }
        
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        
        for(char ch : prefix.toCharArray()){
            
            if(cur.children.get(ch) == null)
                return false;
            
            cur = cur.children.get(ch);
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */