package my.com.app;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {

	private Integer key;
	private int priority;
	private ArrayList<Edge> edges;
	
	
	public Vertex() {	
	}
	public Vertex(Integer key, int priority) {
		super();
		this.key = key;
		this.priority = priority;
	}
	
	public Vertex(Integer key) {
		super();
		this.key = key;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public ArrayList<Edge> getedges(){
		return this.edges;
	}
	
	public void setedges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
	public int compareTo(Vertex v) {
		if(this.getPriority() > v.getPriority() )
			return 1;
		
		else if (this.getPriority() < v.getPriority()) {
			return -1;
		}
	
		else
			return 0;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vertex [key=" + key + ", priority=" + priority + ", edges=" + edges + "]";
	}
	
	
}
