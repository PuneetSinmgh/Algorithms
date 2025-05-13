package my.com.app;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private int data;
	private List<Vertex> adjlist;
	boolean visited;
	
	public Vertex(int data) {
		
		this.data = data;
		this.adjlist = new ArrayList<>();
		visited = false;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public List<Vertex> getAdjlist() {
		return adjlist;
	}
	public void setAdjlist(List<Vertex> adjlist) {
		this.adjlist = adjlist;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public boolean isVisited() {
		return this.visited;
	}
}
