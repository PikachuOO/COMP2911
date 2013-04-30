
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
		
		sg.addNode(a, 366);
		sg.addNode(b, 0);
		sg.addNode(c, 160);
		sg.addNode(d, 242);
		sg.addNode(e, 161);
		sg.addNode(f, 178);
		sg.addNode(g, 77);
		sg.addNode(h, 151);
		sg.addNode(i, 226);
		sg.addNode(l, 244);
		sg.addNode(n, 234);
		sg.addNode(m, 241);
		sg.addNode(o, 380);
		sg.addNode(p, 98);
		sg.addNode(rv, 193);
		sg.addNode(s, 253);
		sg.addNode(t, 329);
		sg.addNode(u, 80);
		sg.addNode(v, 199);
		sg.addNode(z, 374);
		
		sg.addEdge(a, z, 75);
		sg.addEdge(a, s, 140);
		sg.addEdge(a, t, 118);
		sg.addEdge(z, o, 71);
		sg.addEdge(o, s, 151);
		sg.addEdge(s, o, 151);
		sg.addEdge(s, f, 99);
		sg.addEdge(s, rv, 80);
		sg.addEdge(t, l, 111);
		sg.addEdge(l, m, 70);
		sg.addEdge(m, d, 75);
		sg.addEdge(d, c, 120);
		sg.addEdge(rv, c, 146);
		sg.addEdge(c, rv, 146);
		sg.addEdge(c, p, 138);
		sg.addEdge(rv, p, 97);
		sg.addEdge(p, c, 138);
		sg.addEdge(p, rv, 97);
		sg.addEdge(f, b, 211);
		sg.addEdge(p, b, 101);
		sg.addEdge(b, g, 90);
		sg.addEdge(b, u, 85);
		sg.addEdge(u, h, 98);
		sg.addEdge(u, v, 142);
		sg.addEdge(h, e, 86);
		sg.addEdge(v, i, 92);
		sg.addEdge(i, n, 87);
		
		sg.AStarSearch(a, b);
	}
}
