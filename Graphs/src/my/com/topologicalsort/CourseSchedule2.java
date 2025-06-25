package my.com.topologicalsort;

import java.util.*;
// course schedule II: 
// approaches:  Implement Kahn's algorithm for topological sorting using BFS
//  We create an adjacency list to represent the graph,
//  and an array to keep track of the in-degrees of each node.
//  We then initialize a queue with all nodes that have an in-degree of 0.
//  We repeatedly remove nodes from the queue, add them to the result, and decrease the in-degrees of their neighbors.

// time complexity: O(V + E) where V is the number of vertices (courses) and E is the number of edges (prerequisites).
//  Space complexity: O(V + E) for the adjacency list and in-degree array.

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         
        int[] inorder = new int[numCourses];
        
        Arrays.fill(inorder, 0);
        int[] res = new int[numCourses];
        
        // boolean[] visited = new boolean[numCourses];
        //Arrays.fill(visited, false);
        
        HashMap<Integer, List<Integer>> hm = new HashMap();
        
        for (int i =0 ; i<numCourses ; i++){
            hm.put( i,  new ArrayList() ); 
        }
       
        for ( int[] arr : prerequisites) {  
            hm.computeIfAbsent( arr[1], k -> new ArrayList() ).add(arr[0]); 
            inorder[arr[0]] +=1;
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque();
        
        for (int i =0 ; i<numCourses ; i++){
            if ( inorder[i] == 0)
                queue.add(i);
        }
        int count = 0;
        
        while(!queue.isEmpty()){
            
            int s = queue.poll();
            res[count++] = s;
            
                
            List<Integer> dep = hm.get(s);
            for ( int d : dep ){
                inorder[d] -= 1;

                if ( inorder[d] == 0)
                    queue.add(d);
            }            
        }
            
       if(count == numCourses)
            return res;    
        else
           return new int[0];
    }
}