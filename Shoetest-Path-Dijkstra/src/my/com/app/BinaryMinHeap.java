package my.com.app;

import java.util.ArrayList;
import java.util.Comparator;

public class BinaryMinHeap {

	ArrayList<Vertex> vertices ;
	int heapsize;
	
	public BinaryMinHeap() {
		this.vertices = new ArrayList<Vertex>();
	}
	
	public BinaryMinHeap(ArrayList<Vertex> vertices) {
		super();
		this.vertices = vertices;
	}

	private static class Defaultcomparator implements Comparator<Vertex> {

		@Override
		public int compare(Vertex v1, Vertex v2) {		
			return v1.compareTo(v2);
		}
		
	}
	
	public Vertex extractMin() {
		if(vertices.size()<=0) {
			return null;
		}
		else {
			Vertex minval=vertices.get(0);
			vertices.set(0,vertices.get(vertices.size()-1)); // add last position value to the 
			vertices.remove(vertices.size()-1);
			minheapify(vertices, 0);
			return minval;
		}
	}
	
	public void minheapify(ArrayList<Vertex> vertices, int i ) {
		
		int left = 2*i +1;
		int right = 2*i +2;
		int smallest = 0;
		// check weather left and right indexes exist and weather there values are less then value at index i
		if (left <= vertices.size()-1 && vertices.get(left).compareTo(vertices.get(i)) <0)
			smallest= left;
		else
			smallest= i;
		
		if (right <=vertices.size()-1 && vertices.get(right).compareTo(vertices.get(smallest))<0)
			smallest = right;
		
		// if i is not the smallest value then swap the value at i with smallest value int 
		if (smallest != i) {
			swap(vertices, i ,smallest);
			minheapify(vertices, smallest);
		}
		
	}
	
	public void swap (ArrayList<Vertex> v ,int  i ,int j ) {
		Vertex V = v.get(i);
		v.set(i, v.get(j));
		v.set(j, V);
	}
	
	public void insert(Vertex v) {
		
		vertices.add(v);
		int index = vertices.size()-1;
		
		while(index > 0 && vertices.get(index).compareTo(vertices.get(parent(index)))<0) {
			swap(vertices, index, parent(index));
			index = parent(index);
		}
	}
	
	public int parent(int i) {
		return (i-1)/2;
	}
	
	public void decreasepriority(int key , int newpriority) {
	
		int i=0;
			
		for (Vertex vertex : vertices) {
			if (vertex.getKey()==key)
				i=vertices.indexOf(vertex); // returns -1 if no such index
		}
		
		vertices.get(i).setPriority(newpriority); // this can violate min heap priority
		
		while(i > 0 && vertices.get(i).compareTo(vertices.get(parent(i)))<0) {
			swap(vertices, i, parent(i));
			i = parent(i);
		}
	}
	
	public Boolean isEmpty() {
	
		if (vertices.size()==0)
			return true;
		else 
			return false;
	}
	
	public boolean contains(int key) {
		 
		for (Vertex vertex : vertices) 
			if (vertex.getKey()==key)
				return true;

		return false;
			
	}
	public int getweight(int key) {
		
		for (Vertex vertex : vertices) 
			if (vertex.getKey()==key)
				return vertex.getPriority();
		return 0;
	}
}
