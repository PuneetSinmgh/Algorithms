package my.com.app;

public class Edge {

	private int fromVertexindex;
	private int toVertexindex;
	private int weight;
	
	public Edge() {
		
	}
	
	public int getFromVertex() {
		return fromVertexindex;
	}


	public void setFromVertex(int fromVertex) {
		this.fromVertexindex = fromVertex;
	}


	public int getToVertex() {
		return toVertexindex;
	}


	public void setToVertex(int toVertex) {
		this.toVertexindex = toVertex;
	}


	public int getEdgeWeight() {
		return weight;
	}


	public void getEdgeWeight(int weight) {
		this.weight = weight;
	}


	public Edge(int fromVertex, int toVertex, int weight) {
		super();
		this.fromVertexindex = fromVertex;
		this.toVertexindex = toVertex;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [fromVertexindex=" + fromVertexindex + ", toVertexindex=" + toVertexindex + ", weight="
				+ weight + "]";
	}
	
	
	
	
	
}
