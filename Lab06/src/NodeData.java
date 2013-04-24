import java.util.LinkedList;


public class NodeData {

	public NodeData(Node n) {
		node = n;
		paths.add(node);
	}
	
	public Node getNode() {
		return node;
	}
	
	private Node node;
	private LinkedList<Node> paths = new LinkedList<Node>();
}
