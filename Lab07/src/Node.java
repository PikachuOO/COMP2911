import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Node {
	
	public Node(String aName, int h) {
		this.name = aName;
		this.heuristic = h;
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
	
	public int getHeuristic() {
		return this.heuristic;
	}
	
	public LinkedList<Edge> getConnection() {
		return this.connection;
	}
	
	public void sortConnections() {
		Collections.sort(this.getConnection(), new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return (e1.getNode().getName().compareTo(e2.getNode().getName()));
			}
			
		});
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
	private int heuristic;
	private LinkedList<Edge> connection;
}
