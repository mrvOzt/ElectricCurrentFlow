package Graph;

import java.util.ArrayList;

public class Vertex {
	private String name;
	public ArrayList<Edge> edges;
	public ArrayList<String> strEdge;
	private Vertex parent;
	public int outPower;
	public int inPower;
	
	public Vertex(String name) {
		this.name = name;
		edges = new ArrayList<Edge>();
		strEdge = new ArrayList<String>();
		parent = null;
	}

	public void addEdge(Edge e) {
		edges.add(e);
		strEdge.add(e.getSource().getName() + e.getDestination().getName());
	}

	public ArrayList<Edge> getEdges() {
		return this.edges;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vertex getParent() {
		return parent;
	}

	public void setParent(Vertex parent) {
		this.parent = parent;
	}

}

