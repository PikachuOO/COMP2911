import java.util.HashMap;


public class FloatGraph implements Graph {
	
	public FloatGraph() {
		floatGraph = new HashMap<Integer, HashMap<Integer,Boolean>>();
		connection = new HashMap<Integer, Boolean>();
	}

	@Override
	public void addNode(Object o) throws Exception {
		// TODO Auto-generated method stub
		if (o instanceof Integer) {
			connection.put((Integer) o, null);
			floatGraph.put((Integer) o, connection);
		} else
			throw new Exception("Invalid input.");
		
	}

	@Override
	public void addEdge(Object from, Object to) throws Exception {
		// TODO Auto-generated method stub
		if (from instanceof Integer && to instanceof Integer) {
			
		} else
			throw new Exception("Invalid input.");
	}

	@Override
	public Boolean isConnected(Object from, Object to) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Boolean hasNode(int aIndex) {
		return floatGraph.containsKey(aIndex);
	}

	private static HashMap<Integer, HashMap<Integer, Boolean>> floatGraph;
	private static HashMap<Integer, Boolean> connection;
}
