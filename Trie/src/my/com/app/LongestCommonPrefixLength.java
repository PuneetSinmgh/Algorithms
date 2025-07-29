package my.com.app;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefixLength {
    
    public int longestCommonPrefixUsingSet(int[] arr1, int[] arr2) {
        
        Set<Integer> prefixSet = new HashSet<>();

        for( int i : arr1 ){
            while(i>0){
                prefixSet.add(i);
                i = i/10;
            }
        }

        int maxLen = Integer.MIN_VALUE;

        for( int  x : arr2){
            while(x>0){
                if (prefixSet.contains(x)){
                    maxLen = Math.max( maxLen , String.valueOf(x).length() );
                    break;
                }
                x = x/10;
            }
        }

        return maxLen==Integer.MIN_VALUE ? 0 : maxLen ;
    }

    // Using trie data structure
    public int longestCommonPrefixUsingTrie(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();
        
        for (int num : arr1) {
            insertIntoTrie(root, num);
        }

        int maxLen = Integer.MIN_VALUE;

        for (int num : arr2) {
            maxLen = Math.max(maxLen, searchInTrie(root, num));
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
    private void insertIntoTrie(TrieNode root, int num) {
        TrieNode current = root;
        String strNum = String.valueOf(num);
        for (char c : strNum.toCharArray()) {
            int index = c - '0';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfNumber = true;
    }
    private int searchInTrie(TrieNode root, int num) {
        TrieNode current = root;
        String strNum = String.valueOf(num);
        int length = 0;

        for (char c : strNum.toCharArray()) {
            int index = c - '0';
            if (current.children[index] == null) {
                break; // No common prefix found
            }
            current = current.children[index];
            length++;
        }

        return length;
    }
    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfNumber;

        TrieNode() {
            children = new TrieNode[10]; // Assuming digits 0-9
            isEndOfNumber = false;
        }
    }
    public static void main(String[] args) {
        LongestCommonPrefixLength solution = new LongestCommonPrefixLength();
        
        int[] arr1 = {123, 124, 125};
        int[] arr2 = {1234, 1235, 126};

        System.out.println("Longest Common Prefix Length using Set: " + 
            solution.longestCommonPrefixUsingSet(arr1, arr2)); // Output: 3

        System.out.println("Longest Common Prefix Length using Trie: " + 
            solution.longestCommonPrefixUsingTrie(arr1, arr2)); // Output: 3
    }
}
