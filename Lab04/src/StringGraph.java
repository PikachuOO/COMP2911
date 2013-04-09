import java.util.Iterator;
import java.util.LinkedList;

public class StringGraph implements Graph {
	
	public StringGraph() {
		stringGraph = new LinkedList<Node>();
	}

	@Override
	public void addNode(Object o) throws Exception {
		if (o instanceof String) {
			if (hasNode((String) o)) {
				System.out.println(o + " already exists.");
				return;
			}
			Node n = new Node((String) o);
			stringGraph.add(n);
			System.out.println("Node " + o + " added.");
		} else {
			throw new Exception("Invalid datatype");
		}
	}

	@Override
	public void addEdge(Object from, Object to) throws Exception {
		if (from instanceof String && to instanceof String) {
			Node f = containNode((String) from);
			
			if (from.equals(to)) {
				System.out.println("Cannot connect to itself.");
				return;
			}				
			
			if (hasNode((String) to)) {
				Edge e = new Edge((String) to);
				if (f != null && (!f.hasConnection(e))) {
					f.getConnection().add(e);
					System.out.println("Connecion from " + from +
							" to " + to + " is formed.");
				}
				else
					System.out.println("There is no node named " + from
							+ " or the connection already exists.");
			} else
				System.out.println("There is no node named " + to);
			
		} else {
			throw new Exception("Invalid input");
		}
	}

	@Override
	public Boolean isConnected(Object from, Object to) throws Exception {
		// TODO Auto-generated method stub
		if (from instanceof String && to instanceof String) {
			Node f = containNode((String) from);
			Iterator<Edge> iter = f.getConnection().iterator();
			Edge e  = null;
			
			if (hasNode((String) to)) {
				if (iter.hasNext()) {
					e = iter.next();
					if (e.getNode().getName().equals((String) to)) {
						System.out.println("Is connected.");
						return true;
					}
					from = e.getNode().getName();
					if (iter.hasNext())
						to = iter.next().getNode().getName();
					else {
						System.out.println("Not connected.");
						return false;
					}
					return isConnected(f, to);
				} else {
					System.out.println("Not connected.");
				}
			} else
				System.out.println(to + " does not exist.");
		} else
			throw new Exception("Invalid input");
		
		return false;
	}
	
	/**
	 * Checks if there already exists a vertex of
	 * the same name.
	 * @param aName A String.
	 * @return True if the name exists. False otherwise.
	 */
	public Boolean hasNode(String aName) {
		for (Node n : stringGraph) {
			if (n.getName().equals(aName))
				return true;
		}
		return false;
	}
	
	/**
	 * Checks if a vertex already exists in the list
	 * and returns the matching node.
	 * @param aName A String.
	 * @return A node with the matching name.
	 */
	public Node containNode(String aName) {
		for (Node n : stringGraph) {
			if (n.getName().equals(aName))
				return n;
		}
		return null;
	}

	private static LinkedList<Node> stringGraph;
}
