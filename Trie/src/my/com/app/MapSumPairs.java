package my.com.app;
import java.util.*;
// https://leetcode.com/problems/map-sum-pairs/description/
// https://leetcode.com/problems/map-sum-pairs/solutions/3297713/java-trie-implementation/
// approach : implement a trie data structure to store the key-value pairs	
// and maintain the sum of values for each prefix in the trie nodes.

class TrieNode{

    int val;
    boolean isKey;
    int sum;
    TrieNode[] childs;

    public TrieNode(){
        val = 0;
        isKey = false;
        sum =0;
        childs = new TrieNode[26];
    }
}
class Trie{

    TrieNode root;

    public Trie(){

        root = new TrieNode();
    
    }
    
    public void insert( char[] key , int val){
        
        TrieNode temp = this.root; 
        for ( char c : key ){
            TrieNode t;
            if (temp.childs[c - 'a']!=null){
                t = temp.childs[c - 'a'];
            } else {
                t = new TrieNode();
                temp.childs[c - 'a'] = t;
            }
            t.sum += val;
            temp = t;
        }
        temp.isKey=true;
        temp.val = val;
    }

    public void update( char[] key , int prevVal , int val){
        
        TrieNode temp = this.root; 
        for ( char c : key ){
            TrieNode t;
            if (temp.childs[c - 'a']!=null){
                t = temp.childs[c - 'a'];
            } else {
                t = new TrieNode();
                temp.childs[c - 'a'] = t;
            }
            t.sum -= prevVal;
            t.sum += val;
            temp = t;
        }
        temp.val = val;
    }

    public int prefixSum(char[] key ){

        TrieNode temp = this.root; 
        for ( char c : key ){

            if (temp.childs[c - 'a'] == null){ // if the trie path ends before ending the string
                return 0;
            } 
            
            temp = temp.childs[c - 'a'];
        }
        return temp.sum;       
    }

    public boolean containsKey(char[] key){
        TrieNode temp = this.root; 
        for ( char c : key){
            if (temp.childs[c - 'a'] == null){ // if the trie path ends before ending the string
                return false;
            } 
            temp = temp.childs[c - 'a'];
        }
        return temp.isKey;
    }

    public int get(char[] key){
        TrieNode temp = this.root; 
        for ( char c : key){

            temp = temp.childs[c - 'a'];
        }
        return temp.val;
    }
    
}

class MapSum {

    Trie trie;

    public MapSum() {
        trie = new Trie();    
    }
    
    public void insert(String key, int val) {
        char[] keyArr = key.toCharArray();
        if ( trie.containsKey(keyArr) ){
            int value = trie.get(keyArr);
            trie.update( keyArr, value, val);
        } else {
            trie.insert( keyArr, val);
        }
    }
    
    public int sum(String prefix) {
        char[] keyArr = prefix.toCharArray();
        return trie.prefixSum(keyArr);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */