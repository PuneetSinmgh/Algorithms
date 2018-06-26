package my.com.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Graph {


	Integer noofvertex;
	Integer noofedge;
	Map<Integer, Vertex> allvertices = new HashMap<>();
	Map<Vertex, Vertex> parents = new HashMap<>();  // hashmap to store parent of adjacent vertices
	
	ArrayList<Edge> adjacencyList[] = new ArrayList[15];
	
	public Graph(int noofvertex, int noofedges) {
		
		this.noofedge = noofedges;
		this.noofvertex = noofvertex;
		for (int i=0; i<noofvertex ; i++) {
			adjacencyList[i]= new ArrayList<>();
		}
	}
	
	public void addEdge(Edge e) {
		
		Vertex vertex1 = null;
        if(allvertices.containsKey(e.getFromVertex())){
            vertex1 = allvertices.get(e.getFromVertex());
        }else{
            vertex1 = new Vertex(e.getFromVertex(), Integer.MAX_VALUE );
            allvertices.put(e.getFromVertex(), vertex1);
        }
        Vertex vertex2 = null;
        if(allvertices.containsKey(e.getToVertex())){
            vertex2 = allvertices.get(e.getToVertex());
        }else{
            vertex2 = new Vertex(e.getToVertex(), Integer.MAX_VALUE); // 
            allvertices.put(e.getToVertex(), vertex2);
        }
        
		adjacencyList[e.getFromVertex()-1].add(e); // add new edge into adjacency list
		
	}



	public Map<Vertex,Integer> shorteshpath( int sourceKey){
		
		BinaryMinHeap minheap = new BinaryMinHeap();
		Vertex sourcevertex = new Vertex(sourceKey, 0);
		Map<Vertex, Integer> distances = new HashMap<>(); // hashmap to store shortest distance from source path
	
		for (Vertex vertex: allvertices.values() ) {   // initialize the minheap with all vertices
			minheap.insert(vertex);
		}
		
		//System.out.println(minheap.vertices.toString());
		
		minheap.decreasepriority(sourceKey,0);  	// decrease the priority of source vertex to zero	
		distances.put(sourcevertex, 0);  // distance of source from source is zero
		parents.put(sourcevertex, null); 	// set parent of source = null
		
		while(!minheap.isEmpty()) {
			
			Vertex curerntVertex = minheap.extractMin();
			distances.put(curerntVertex, curerntVertex.getPriority());
			
			for (Edge edge : adjacencyList[curerntVertex.getKey()-1]) {
				Vertex adjacent = allvertices.get(edge.getToVertex()); // get adjacent vertex from the iterating over adjacency list
				
				if (!minheap.contains(adjacent.getKey())) {  // check if adjacent vertex is present in minheap or not if not then it has already shortest distance from source 
					continue;
				}
			int newDistance = distances.get(curerntVertex) + edge.getEdgeWeight();
			if(minheap.getweight(adjacent.getKey())> newDistance) {
				
				minheap.decreasepriority(adjacent.getKey(), newDistance);  // decrease the shortest distance from source path
				parents.put(adjacent, curerntVertex); // add current vertex as parent of adjacent vertex
				
				}
			}
		}
		return distances;	
	}
	
	
	public void getShortestPath(Vertex source, Vertex destination){
	
		Vertex child = destination;
		Vertex parent= null;
		System.out.println("shortet path from source to destination ");
		
		while(child.getKey()!=source.getKey()) {
			parent=parents.get(child);
			System.out.println("child:"+ child.toString() + "parent:"+ parent.toString());
			child=parent;
		}	
	}
	
	
	
}
