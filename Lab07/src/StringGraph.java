import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class StringGraph implements Graph {
	
	public StringGraph() {
		stringGraph = new LinkedList<Node>();
	}

	@Override
	public void addNode(Object o, int heuristic) throws Exception {
		if (o instanceof String) {
			if (hasNode((String) o)) {
				System.out.println(o + " already exists.");
				return;
			}
			Node n = new Node((String) o, heuristic);
			stringGraph.add(n);
			System.out.println("Node " + o + " added.");
		} else {
			throw new Exception("Invalid datatype");
		}
	}

	@Override
	public void addEdge(Object from, Object to, int cost) throws Exception {
		if (from instanceof String && to instanceof String) {
			Node f = containNode((String) from);
			Node t = containNode((String) to);
			
			if (from.equals(to)) {
				System.out.println("Cannot connect to itself.");
				return;
			}				
			
			if (hasNode((String) to)) {
				Edge e = new Edge(t, cost);
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
			if (n.getName().equalsIgnoreCase(aName))
				return n;
		}
		return null;
	}
	
	public void BFS(String start, String end) {
		NodeData currentNode = new NodeData(this.containNode(start));
		NodeData endNode = new NodeData(this.containNode(end));
		unvisitedNodes.add(currentNode);
		while (currentNode.getNode() != endNode.getNode() && unvisitedNodes.size() > 0) { 
			
			currentNode = unvisitedNodes.poll();
			
			if (visitedNodes.contains(currentNode)) {
				continue;	// we have already visited this node. 
			}
			// add the node to the visited list 
			visitedNodes.add(currentNode);
			
			// add the children to the toVisit list. // or openlist
			currentNode.getNode().sortConnections();
			LinkedList<Edge> connections = currentNode.getNode().getConnection();
			for (Edge c : connections) {
				Boolean addToQueue = true;
				for (NodeData d : visitedNodes) {
					if (d.getNode() == c.getNode()) {
						addToQueue = false;
						break;
					}
				}
				if (addToQueue)
					unvisitedNodes.add(new NodeData(c.getNode()));
			}
		}
		System.out.println("out of the loop");
	}
	
	public void AStarSearch(String start, String end) {
		NodeData startNode = new NodeData(this.containNode(start));
		NodeData currentNode = new NodeData(this.containNode(start));
		NodeData endNode = new NodeData(this.containNode(end));
		int cost = currentNode.getNode().getHeuristic() + 0;
		currentNode.setCost(cost);
		unvisitedNodes.add(currentNode);
		int currentCost = 0, costSum = 0;
		
		while (currentNode.getNode() != endNode.getNode() && unvisitedNodes.size() > 0) {
			currentNode = unvisitedNodes.poll();
			
			if (visitedNodes.contains(currentNode)) {
				continue;	// we have already visited this node. 
			}
			// add the node to the visited list 
			visitedNodes.add(currentNode);
			
			// add the children to the unvisitedNodes list. 
			currentNode.getNode().sortConnections();
			LinkedList<Edge> connections = currentNode.getNode().getConnection();
			for (Edge c : connections) {
				for (NodeData d : visitedNodes) {
					if (d.getNode() == c.getNode()) {
						continue;
					}
				}
				
				NodeData n = new NodeData(c.getNode());
				if (currentNode.getNode().getName().equals(startNode.getNode().getName()))
					n.setCost(n.getNode().getHeuristic() + (currentCost + c.getCost()));
				else
					n.setCost(n.getNode().getHeuristic() + (currentCost + c.getCost()) + startNode.getNode().getConnection().peek().getCost());
				unvisitedNodes.add(n);
			}
			
			sortNodesByCost();			
		}
	}
	
	public void sortNodesByCost() {
		Collections.sort(unvisitedNodes, new Comparator<NodeData>() {

			@Override
			public int compare(NodeData o1, NodeData o2) {
				if (o1.getCost() > o2.getCost())
					return 1;
				return -1;
			}			
		});
	}

	private LinkedList<Node> stringGraph;
	private LinkedList<NodeData> unvisitedNodes = new LinkedList<NodeData>();
	private LinkedList<NodeData> visitedNodes = new LinkedList<NodeData>();
}
