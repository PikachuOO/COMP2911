import java.util.LinkedList;

public class Node {
	
	public Node(String aName) {
		this.name = aName;
		setConnection();
	}
	
	public Node(int index) {
		this.index = index;
		setConnection();
	}
	
	public void setConnection() {
		this.connection = new LinkedList<Edge>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public LinkedList<Edge> getConnection() {
		return this.connection;
	}
	
	public Boolean hasConnection(Edge aEdge) {
		for (Edge e : connection) {
			if (e.getNode().getName().equals(aEdge.getNode().getName()))
				return true;
		}
		return false;
	}
	
	private String name;
	private int index;
	private LinkedList<Edge> connection;
}
