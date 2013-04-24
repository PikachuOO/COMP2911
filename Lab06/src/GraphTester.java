
public class GraphTester {
	public static void main(String args[]) throws Exception {
		testStringGraph();
	}
	
	public static void testStringGraph() throws Exception {
		StringGraph sg = new StringGraph();
		
		String a = "Arad";
		String z = "Zerind";
		String o = "Oradea";
		String s = "Sibiu";
		String t = "Timisoara";
		String l = "Lugoj";
		String m = "Mehadia";
		String d = "Dobreta";
		String rv = "Rimnicu Vilcea";
		String f = "Fagaras";
		String p = "Pitesti";
		String c = "Craiova";
		String n = "Neamt";
		String i = "Iasi";
		String v = "Vaslui";
		String b = "Bucharest";
		String g = "Glurgiu";
		String u = "Urziceni";
		String h = "Hirsova";
		String e = "Eforie";
		
		sg.addNode(a);
		sg.addNode(b);
		sg.addNode(c);
		sg.addNode(d);
		sg.addNode(e);
		sg.addNode(f);
		sg.addNode(g);
		sg.addNode(h);
		sg.addNode(i);
		sg.addNode(l);
		sg.addNode(n);
		sg.addNode(m);
		sg.addNode(o);
		sg.addNode(p);
		sg.addNode(rv);
		sg.addNode(s);
		sg.addNode(t);
		sg.addNode(u);
		sg.addNode(v);
		sg.addNode(z);
		
		sg.addEdge(a, z);
		sg.addEdge(a, s);
		sg.addEdge(a, t);
		sg.addEdge(z, o);
		sg.addEdge(o, s);
		sg.addEdge(s, o);
		sg.addEdge(s, f);
		sg.addEdge(s, rv);
		sg.addEdge(t, l);
		sg.addEdge(l, m);
		sg.addEdge(m, d);
		sg.addEdge(d, c);
		sg.addEdge(rv, c);
		sg.addEdge(c, rv);
		sg.addEdge(c, p);
		sg.addEdge(rv, p);
		sg.addEdge(p, c);
		sg.addEdge(p, rv);
		sg.addEdge(f, b);
		sg.addEdge(p, b);
		sg.addEdge(b, g);
		sg.addEdge(b, u);
		sg.addEdge(u, h);
		sg.addEdge(u, v);
		sg.addEdge(h, e);
		sg.addEdge(v, i);
		sg.addEdge(i, n);
		
		sg.BFS(a, b);
	}
}
