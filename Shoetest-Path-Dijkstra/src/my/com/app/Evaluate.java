package my.com.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Evaluate {

	
	
	public static void main(String[] args) {

			
			Graph graph = new Graph(15,25); // initializing graph with 15 vertices and 25 edges  
			
			Vertex source =new Vertex(1,0);  // considering source vertex as vertex 1 
			
			
			graph.addEdge(new Edge(1, 2, 2));   // adding edges sequentially for each vertex
			graph.addEdge(new Edge(1, 6, 4));
			graph.addEdge(new Edge(1, 7, 1));
			
			graph.addEdge(new Edge(2, 3, 4));
			graph.addEdge(new Edge(2, 7, 3));
			
			graph.addEdge(new Edge(3, 4, 5));
			graph.addEdge(new Edge(3, 8, 8));
			
			graph.addEdge(new Edge(4, 5, 6));
			graph.addEdge(new Edge(4, 9, 10));
			
			graph.addEdge(new Edge(5, 10, 2));
			
			graph.addEdge(new Edge(6, 7, 6));
			graph.addEdge(new Edge(6, 11, 11));
			
			graph.addEdge(new Edge(7, 8, 7));
			graph.addEdge(new Edge(7, 12, 9));
			graph.addEdge(new Edge(7, 13, 1));
			
			graph.addEdge(new Edge(8, 9, 6));
			graph.addEdge(new Edge(8, 13, 11));
			
			graph.addEdge(new Edge(9, 10, 4));
			graph.addEdge(new Edge(9, 14, 10));
			
			graph.addEdge(new Edge(10, 15, 9));
			
			graph.addEdge(new Edge(11, 12, 8));
			
			graph.addEdge(new Edge(12, 13, 10));
			
			graph.addEdge(new Edge(13, 9, 1));
			graph.addEdge(new Edge(13, 14, 5));
			
			graph.addEdge(new Edge(14, 15, 7));
			
			Map<Vertex, Integer> shortestdistances = graph.shorteshpath(source.getKey());  // shortest path function uses Dijkstra algorithm and will calculate shortest path for all vertices from source vertex(source vertex is Vertex 1 )
			
			System.out.println("\nshortest distance for all vertices:\n");
			//Set<Vertex> set =shortestdistances.keySet();
			for (Object v : shortestdistances.keySet().toArray() ) {
				System.out.println("vertex:"+ v.toString()+"  distance:"+ shortestdistances.get(v).toString());
			}
			
			Vertex destination = new Vertex(9, Integer.MAX_VALUE);
			destination.setPriority(shortestdistances.get(destination));
			
			graph.getShortestPath(source, destination);
			
		
	}

}
