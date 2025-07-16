package my.com.dijkstra;

import java.util.*;

// approach: Dijkstra's algorithm
// Time complexity: O(E log V) where E is the number of edges and V is the number of vertices
// Space complexity: O(V + E) for the graph representation and priority queue
// where V is the number of nodes and E is the number of edges in the graph 

// The algorithm works by maintaining a priority queue of nodes to visit, starting from the source node.
// It repeatedly extracts the node with the smallest distance from the queue, updates the distances of its
// neighbors, and adds them to the queue if their distances are updated.    
// The process continues until all nodes are visited or the queue is empty. 


class Solution {
    class Node  {
        int val;
        int dist;

        public Node(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }
    }

    class Edge {
        int adj;
        int wght;

        public Edge(int n, int w) {
            this.adj = n;
            this.wght = w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        
        Node[] allnodes = new Node[n+1];
        Map<Integer,ArrayList<Edge>> gh = new HashMap();

        int maxd = Integer.MIN_VALUE;

        for(int[] e : times) {
            
            ArrayList l = gh.getOrDefault(e[0], new ArrayList());
            Edge ed = new Edge(e[1], e[2]);
            l.add(ed);
            gh.put(e[0], l);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>( new Comparator<Node>(){
            @Override
            public int compare(Node n1 , Node n2){
                return n1.dist - n2.dist;
            }
        }); 

        for(int i =1 ; i<=n ; i++ ){
            Node node = new Node(i, Integer.MAX_VALUE);
            if ( i == k ){
                node.dist = 0;
            }
            //pq.add(node);
            allnodes[i] = node;
        }
        pq.add(allnodes[k]);
        while (!pq.isEmpty()) {
            Node u = pq.poll();

            if(gh.get(u.val) != null) {
                
                for( Edge v : (List<Edge>)gh.get(u.val)) {
                    
                    Node n2 = allnodes[v.adj];

                    if ( u.dist + v.wght < n2.dist){
                        n2.dist = u.dist + v.wght;
                        pq.add(n2);
                    }
                }
            }                
        }

        for(int i =1 ; i<=n ; i++ ){
            if (allnodes[i].dist == Integer.MAX_VALUE)
                return -1;
            
            if ( allnodes[i].dist > maxd)
                maxd = allnodes[i].dist;
        }
        return maxd;
    }
}