package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		
		// MaxFlow kısmı ford fulkerson algoritması ile yapıldı.
		// geeksforgeeks'ten alındı.
		// case 1 ,case 2 ,case 3 tamamlandı.
		
		Graph graph = new Graph(1518);
		String source;
		String dest;
		int weight;
		int s;
		int d;
		Scanner sc = new Scanner(new File("graph.txt"));
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] splitted = line.split("\\t");
			source = splitted[0];
			dest = splitted[1];
			weight = Integer.valueOf(splitted[2]);
			graph.addEdge(source, dest, weight);
			
			s = graph.vertices.indexOf(source);
			d = graph.vertices.indexOf(dest);
			
			Vertex vSource = graph.originVertex.get(s);
			vSource.outPower = vSource.outPower + weight;
			Vertex vDest = graph.originVertex.get(d);
			vDest.inPower = vDest.inPower + weight;
			
			Edge e = new Edge(vSource,vDest,weight);
			vSource.addEdge(e);
			
		}
		s = graph.vertices.indexOf("BKB");
		d = graph.vertices.indexOf("AK");
		Vertex initial = graph.originVertex.get(s);
		MaxFlow m = new MaxFlow();
		int result = m.fordFulkerson(graph.getAdjacency(),s,d);
		System.out.println("Max flow is " + result);
		m.changeEdgeForMaximize(graph);
		
	}
}
