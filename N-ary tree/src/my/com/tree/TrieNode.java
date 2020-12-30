package my.com.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode{
    
    Character ch;
    Map<Character, TrieNode> children;
    boolean isWord;
   
   public TrieNode(char ch ){
       this.ch = ch;
       this.isWord = false;
       this.children = new HashMap();
   }
}
