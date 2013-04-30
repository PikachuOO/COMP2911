
public interface Graph {
	public void addNode(Object o, int heuristic) throws Exception;
	public void addEdge(Object from, Object to, int cost) throws Exception;
	public Boolean isConnected(Object from, Object to) throws Exception;
}
