package my.com.bellmanford;

import java.util.*;

class Node{
    
    int price;
    int idx;

    public Node(int i, int p){
       
        price = p;
        idx = i;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
/*
        HashMap<Integer, List<Node>> hm = new HashMap();
        ArrayDeque<Node> que = new ArrayDeque();
        
        for ( int[] ar : flights ){
            hm.computeIfAbsent(ar[0], value -> new ArrayList()).add(new Node(ar[1], ar[2])) ;
        }
        
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);

        que.add(new Node(src, 0));
        int stops = 0;

        while (stops<=k && !que.isEmpty()){

            int sz = que.size();
            for (int i=0 ; i<sz; i++){
                
                Node curr = que.poll();
                
                if ( !hm.containsKey(curr.idx))
                    continue;

                for ( Node sn : hm.get(curr.idx)){
                    
                    if ( sn.price + curr.price >= prices[sn.idx])
                        continue;
                    
                    prices[sn.idx] =  sn.price + curr.price;
                    sn.price = prices[sn.idx];
                    que.offer(sn);
                    
                }
            }
            stops ++;
        }
        
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
        */

         Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] i : flights)
            adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] { i[1], i[2] });

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { src, 0 });
        int stops = 0;

        while (stops <= k && !q.isEmpty()) {
            int sz = q.size();
            // Iterate on current level.
            while (sz-- > 0) {
                int[] temp = q.poll();
                int node = temp[0];
                int distance = temp[1];

                if (!adj.containsKey(node))
                    continue;
                // Loop over neighbors of popped node.
                for (int[] e : adj.get(node)) {
                    int neighbour = e[0];
                    int price = e[1];
                    if (price + distance >= dist[neighbour])
                        continue;
                    dist[neighbour] = price + distance;
                    q.offer(new int[] { neighbour, dist[neighbour] });
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}