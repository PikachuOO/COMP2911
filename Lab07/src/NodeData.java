import java.util.LinkedList;


public class NodeData {
	
	public NodeData(Node n) {
		node = n;
		paths.add(node);
	}

	public void setCost(int c) {
		this.cost = c;
	}
	
	public Node getNode() {
		return node;
	}
	
	public Integer getCost() {
		return Integer.valueOf(cost);
	}
	
	private Node node;
	private int cost;
	private LinkedList<Node> paths = new LinkedList<Node>();
}
