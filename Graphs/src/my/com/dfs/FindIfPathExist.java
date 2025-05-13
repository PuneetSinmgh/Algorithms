package my.com.app;

// find if path exist in undirected graph
// create graph using HashMap
// use DFS to find if path exist
// insert edges in both directions
// Use stack to do DFS iteratively
// Visit each node only once, so mark visited nodes, And push each edge to stack, if not visited
// if destination is found, return true
// if stack is empty and destination is not found, return false

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        int[] visited  = new int[n];
        Arrays.fill(visited, 0);
        
        HashMap<Integer , List<Integer>> gh = new HashMap();
        
        for(int i=0 ; i<edges.length; i++){
            List<Integer> l1 =  gh.getOrDefault( edges[i][0], new ArrayList() );
            List<Integer> l2 =  gh.getOrDefault( edges[i][1], new ArrayList() );
            l1.add(edges[i][1]);
            l2.add(edges[i][0]);
            gh.put( edges[i][0] , l1 );  
            gh.put( edges[i][1] , l2 );  
        }
        
        ArrayDeque<Integer> st = new ArrayDeque();
        
        st.push(source);
        
        while( !st.isEmpty()){
            
            int v = st.pop();
            
            if (v == destination)
                return true;
            
            
            if ( visited[v] == 0 ){
                
                for( int i : gh.get(v)){
                    if (visited[i] == 0 ) // only add to the stack if not visited 
                        st.push(i);
                }
                visited[v] = 1;
            }
        }
        return visited[destination] == 1 ? true : false;
    }
}