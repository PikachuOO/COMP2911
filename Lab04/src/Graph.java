
public interface Graph {
	public void addNode(Object o) throws Exception;
	public void addEdge(Object from, Object to) throws Exception;
	public Boolean isConnected(Object from, Object to) throws Exception;
}
