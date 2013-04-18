
public class Edge {
	
	public Edge(String aName) {
		this.to = new Node(aName);
	}
	
	public Edge(int aIndex) {
		this.to = new Node(aIndex);
	}
	
	public Node getNode() {
		return this.to;
	}
	
	private Node to;
}
