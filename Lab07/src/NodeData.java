//import java.util.LinkedList;


public class NodeData {
	
	public NodeData(Node n) {
		node = n;
//		paths.add(node);
	}

	public void setParent(NodeData n) {
		this.parent = n;
	}
	
	public void setCost(int c) {
		this.cost = c;
	}
	
	public Node getNode() {
		return node;
	}
	
	public NodeData getParent() {
		return parent;
	}
	
	public Integer getCost() {
		return Integer.valueOf(cost);
	}
	
	private Node node;
	private int cost;
	private NodeData parent;
//	private LinkedList<Node> paths = new LinkedList<Node>();
}
