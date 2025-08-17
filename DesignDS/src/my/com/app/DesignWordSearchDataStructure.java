package my.com.app;

import java.util.*;


class TrieNode{
    
    Map<Character, TrieNode> childs; 
    boolean eow;
    
    public TrieNode(){
        childs = new HashMap<>();
        eow = false;
    }
    
    public TrieNode(char ch){
        
        childs.put(ch ,  new TrieNode());
    }
   
}

public class DesignWordSearchDataStructure {

    TrieNode root;

    public DesignWordSearchDataStructure() {
        root = new TrieNode();    
    }
    
    public void addWord(String word) {
        
        TrieNode curr = root;

        for ( char ch : word.toCharArray()){
            
            if ( !curr.childs.containsKey( ch )) {
                curr.childs.put(ch ,  new TrieNode());
            } 
            
            curr = curr.childs.get(ch);
        }
        curr.eow = true;
    }
    
    /** Returns if the word is in the node. */
public boolean searchInNode(String word, TrieNode curr) {
    for (int i = 0; i < word.length(); ++i) {
        char ch = word.charAt(i);

        if (!curr.childs.containsKey(ch)) {
            // If the current character is '.'
            // check all possible nodes at this level
            if (ch == '.') {
                for (TrieNode x : curr.childs.values()) {
                     
                    if (searchInNode(word.substring(i + 1), x )) {
                        return true;
                    }
                }
            }
            // If no nodes lead to answer
            // or the current character != '.'
            return false;
        } else {
            // If the character is found
            // go down to the next level in trie
            curr = curr.childs.get(ch);
        }
    }
    return curr.eow;
}

    /** seacrch in Trie for given word */
    public boolean search(String word) {
        return searchInNode(word, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */