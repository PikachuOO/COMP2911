
public class Edge {
	
	public Edge(Node n, int cost) {
		this.to = n;
		this.cost = cost;
	}
	
	public Edge(int aIndex) {
		this.to = new Node(aIndex);
	}
	
	public Node getNode() {
		return this.to;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	private Node to;
	private int cost;
}
