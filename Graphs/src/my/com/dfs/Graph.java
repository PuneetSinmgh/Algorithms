package my.com.dfs;

import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

	Map<Integer, Vertex> allvertices; 
	List<Edge> alledges;
	
	public Graph() {
		allvertices =  new HashMap<Integer, Vertex>();
		alledges = new ArrayList<Edge>();
	}
	
	public void addvertices(int idx ,int data) {;
		
		Vertex v = new Vertex(data);
		allvertices.put(idx, v);
	}
	
	public void addEdge(Vertex v1 , Vertex v2) {
		
		Edge e = new Edge(v1,v2);
		alledges.add(e);
		v1.getAdjlist().add(v2);
		v2.getAdjlist().add(v1);
	}
	
	public void bfs(Vertex source) {
	
		LinkedList<Vertex> queue = new LinkedList();
		Vertex current;
		List<Vertex> adjl;
		if(source!=null) {
			queue.push(source);
		}
		
		while(!queue.isEmpty()) {
			current = queue.remove();
			
			if(!current.isVisited()) {
				
				System.out.println(current.getData());
				current.setVisited(true);
				
				adjl = current.getAdjlist();
				
				if(adjl.size()>0) {
					for(Vertex v : adjl) {
						queue.add(v);
					}
				}
				
			}
			
		}		
		
	}
	public void dfs(Vertex source) {
		
		LinkedList<Vertex> stack = new LinkedList();
		Vertex current;
		List<Vertex> adjl;
		if(source!=null) {
			stack.push(source);
		}
		
		while(!stack.isEmpty()) {
			current = stack.poll();
			
			if(!current.isVisited()) {
				
				System.out.println(current.getData());
				current.setVisited(true);
				
				adjl = current.getAdjlist();
				
				if(adjl.size()>0) {
					for(Vertex v : adjl) {
						stack.push(v);
					}
				}
				
			}
			
		}
	}
	
}
