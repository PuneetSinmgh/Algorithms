package my.com.circulararray;

import java.util.*;

/**
 * Given a circular array nums of positive and negative integers, return true if there is a circular loop in nums, or false otherwise.
 * A circular loop in nums means:
 * 
 * There exists a loop in nums where:
 * The loop starts and ends at the same index.
 * The loop consists of a sequence of indices such that:
 * Adjacent indices in the sequence differ by 1 or -1.
 * The value at each index in the sequence is either positive or negative, indicating the direction of movement.
 * The loop must be non-empty and must not consist solely of a single element with a value of 0.
 */
// A circular array is an array that wraps around, meaning the last element is adjacent to the first element.
// approach : loop through the array and use a depth-first search (DFS) to find if there is a circular loop.    
// The DFS will traverse the array, marking visited indices and checking for conditions that indicate a circular loop.
// The conditions for a valid circular loop are:
// 1. The loop must not consist solely of a single element with a value of 0.
// 2. The loop must be in the same direction, meaning all elements in the loop must be positive or all must be negative.
// 3. The next index is calculated using modulo operation to handle the circular nature of the array.
// 4. If a visited index is encountered again, it indicates a circular loop.
// 5. If the next index is the same as the current index, it indicates a self-loop, which is not allowed.
// 6. If the direction of movement changes (i.e., the product of the current and next element is negative), it indicates a change in direction, which is not allowed.
// Time Complexity: O(n), where n is the length of the array. Each index is visited at most once.
// Space Complexity: O(n) for the visited array.

class Solution {
   // solution using Map and dfs traversal
    public boolean circularArrayLoop(int[] nums) {
        // no self loop and loop should be in same direction
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited ,false);
        for ( int i=0 ; i < nums.length; i++){
            if (dfs( nums, visited , i))
                return true;
        }
        return false;
    }

    public boolean dfs ( int[] nums, boolean[] visited , int idx){

        if (visited[idx]){
            return true;
        }

        visited[idx] = true;
        int next = Math.floorMod(idx + nums[idx] ,  nums.length);
        
        if ( next == idx || nums[idx]* nums[next] < 0 ){
            visited[idx] = false;
            return false;
        }
        if ( visited[next]){
            return true;
        }
        if ( dfs (nums, visited , next)){
            return true;
        } 
        
        visited[idx]  = false;
        return false;
    }
}