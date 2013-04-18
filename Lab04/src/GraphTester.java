
public class GraphTester {
	public static void main(String args[]) {
		testStringGraph();
	}
	
	public static void testStringGraph() {
		StringGraph sg = new StringGraph();
		String central = "Central";
		String redfern = "Redfern";
		String a = "A";
		
		try {
			sg.addNode(central);
			sg.addNode(redfern);
			sg.addNode(a);
			sg.addNode(central);
			sg.addEdge(central, redfern);
			sg.addEdge(central, a);
			sg.addEdge(central, a);
			sg.isConnected(central, redfern);
			sg.isConnected(redfern, a);
			sg.addNode(1); // throw exception
		} catch (Exception numException) {
			System.out.println("Not accepting a number.");
		}
	}
}
