package src.my.com.app.treebased;

import java.util.*;

// Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
// The number of unique BSTs with n nodes can be calculated using dynamic programming or recursion.
// approach : number of nodes in left subtree = i-1 and number of nodes in right subtree = n-i;
// The total unique number of trees is the Cartesian product of the number of nodes on the left and the number of nodes in the right subtree.
// Time Complexity: O(n^2)


class Solution {
    public int numTrees(int n) {
        //recursive solution: number of node s in left subtree = i-1 and num of node in right sub tree n-i;
        // total unique num of tree is : cartesian product of no of node on left and num of node in right.
        /*
        if ( n == 0)
            return 1;

        if ( n == 1)
            return 1;

        if ( n == 2)
            return 2;

        int sum =0;
        for (int i =1 ; i <= n ; i++){

            sum += numTrees(i-1) * numTrees(n-i);
        }
        return sum;*/

        // iterative solution

        int[] dp = new int[n+1];

        
        dp[0]=1;
        dp[1]=1;

        for (int i = 2 ; i <= n ; i++){
            for (int j = 1 ; j <= i ; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}