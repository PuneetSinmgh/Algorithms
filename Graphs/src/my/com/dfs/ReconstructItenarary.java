package my.com.app.dfs;

// teo solution for Reconstruct Iternary problem

class Solution {
    
    List<String> res = new  ArrayList();
    
    public List<String> findItinerary(List<List<String>> tickets) {
    /*    
        HashMap<String, HashSet<String>> outboundEdges = new HashMap();
        
        PriorityQueue<List<String>> heap = new PriorityQueue<List<String>>((l1 , l2 ) -> {
            
            for ( int i=0 ; i <l1.size() ; i++){
                //int res =  l1.get(i).compareTo(l2.get(i));
                int res = l2.get(i).charAt(0) - l1.get(i).charAt(0);
                if ( res != 0)
                    return res;
            }
            return 0;
        });
        
        for ( List<String> l :  tickets){
            HashSet<String> s1 = outboundEdges.getOrDefault( l.get(0) , new HashSet());
            HashSet<String> s2 = outboundEdges.getOrDefault( l.get(1) , new HashSet());
            s1.add(l.get(1));
            outboundEdges.put(l.get(0) , s1 );
            outboundEdges.put(l.get(1) , s2 );
        }
         List<String> path = new ArrayList();
        path.add("JFK");
        
        dfs (outboundEdges , "JFK" , path, heap , tickets.size()+1);
        
        return heap.size() == 0 ? new ArrayList() : heap.poll();
    }
    
    public void dfs ( HashMap<String, HashSet<String>> outboundEdges, String curr , List<String> path , PriorityQueue<List<String>> heap, int size ){

        if ( outboundEdges.get(curr).size() == 0){
            if ( path.size() == size)
                heap.add(new ArrayList(path));
            return;
        }
        
        String[] strs = outboundEdges.get(curr).toArray(new String[0]);
        for ( String s : strs){
            outboundEdges.get(curr).remove(s);
            path.add(s);
            dfs (outboundEdges , s , path, heap, size );
            path.remove( path.size()-1);
        }
        
    }*/

        HashMap<String, PriorityQueue<String>> outboundEdges = new HashMap();

        // add all the edges to the MAP
        // destination is sorted using Priority Queue , lexographically. 
        for ( List<String> l :  tickets){
            outboundEdges.computeIfAbsent( l.get(0) , k -> new PriorityQueue() ).add(l.get(1));
        }

        dfs( outboundEdges , "JFK");
        return res;
    }

   

    public void dfs ( HashMap<String, PriorityQueue<String>> outboundEdges, String curr){
        // the first traversal should give all destination in lexographiccal order and keep removing them once visited. And add to the result
        // loop over all the edges for source and keep reducing from the priorityQueue for the source
        while ( outboundEdges.containsKey(curr) && !outboundEdges.get(curr).isEmpty()){
            dfs (outboundEdges , outboundEdges.get(curr).poll() );
        }
        res.add( 0, curr);
    }
}