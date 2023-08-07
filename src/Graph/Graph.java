package Graph;
import java.util.ArrayList;

public class Graph {
	public ArrayList<String> vertices; // to keep vertex names
	public ArrayList<Vertex> originVertex;
	private int[][] adjacency; // to keep edges
	private int size;

	public Graph(int size) {
		vertices = new ArrayList<String>();
		originVertex = new ArrayList<Vertex>();
		adjacency = new int[size][size];
		this.size = size;
	}

	public void addEdge(String source, String destination, int weight) {
	 
		if (!vertices.contains(source)) {
			Vertex sVertex = new Vertex(source);
			vertices.add(source);
			originVertex.add(sVertex);
		}
		if (!vertices.contains(destination)) {
			Vertex dVertex = new Vertex(destination);
			vertices.add(destination);
			originVertex.add(dVertex);
		}

		int source_index = vertices.indexOf(source);
		int destination_index = vertices.indexOf(destination);
		adjacency[source_index][destination_index] = weight;
	}

	public int size() {
		return this.size;
	}

	public int[][] getAdjacency() {
		return adjacency;
	}

	public ArrayList<String> getVertices() {
		return vertices;
	}

	public void print() {
		for (String v : vertices) {
			System.out.print("\t(" + v + ")");
		}
		System.out.println();
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print("(" + vertices.get(i) + ")\t");
			for (int j = 0; j < adjacency.length; j++) {
				System.out.print(adjacency[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("Edges");
		int edge_count = 0;
		int total_weight = 0;
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				if (adjacency[i][j] > 0) {
					System.out.println(vertices.get(i) + "-" + vertices.get(j) + ":" + adjacency[i][j]);
					edge_count++;
					total_weight += adjacency[i][j];
				}
			}
		}
		System.out.println("Total " + edge_count + " edges.");
		System.out.println("Total weight is " + total_weight);
		System.out.println();
	}
	
}
