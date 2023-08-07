package Graph;

import java.util.ArrayList;
import java.util.LinkedList;


// ford fulkerson metodu geeks for geekten alındı...



class MaxFlow {
	static final int V = 1518; 
	ArrayList<Integer> changeEdges = new ArrayList<Integer>();

	boolean bfs(int rGraph[][], int s, int t, int parent[])
	{

		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; ++i)
			visited[i] = false;

		LinkedList<Integer> queue
			= new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		parent[s] = -1;

		
		while (queue.size() != 0) {
			int u = queue.poll();

			for (int v = 0; v < V; v++) {
				if (visited[v] == false
					&& rGraph[u][v] > 0) {
			
					if (v == t) {
						parent[v] = u;
						return true;
					}
					queue.add(v);
					parent[v] = u;
					visited[v] = true;
				}
			}
		}

		return false;
	}


	int fordFulkerson(int graph[][], int s, int t)
	{
		
		int u, v;
		int rGraph[][] = new int[V][V];

		for (u = 0; u < V; u++)
			for (v = 0; v < V; v++)
				rGraph[u][v] = graph[u][v];
		
		
		int parent[] = new int[V];

		int max_flow = 0;
		while (bfs(rGraph, s, t, parent)) {
			int path_flow = Integer.MAX_VALUE;
			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				if(rGraph[u][v] < path_flow) {
					if(!(changeEdges.contains(u) && changeEdges.contains(v)) && u!= s) {
						changeEdges.add(u);
						changeEdges.add(v);
					}
					
				}
				path_flow
					= Math.min(path_flow, rGraph[u][v]);
				
			}
			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				rGraph[u][v] -= path_flow;
				rGraph[v][u] += path_flow;
			}
			max_flow += path_flow;
		}
		return max_flow;
	}
	void changeEdgeForMaximize(Graph graph) {
		System.out.println("This edges capacity should be increased");
		for(int i  = 0;i < changeEdges.size();i++) {
			int s = changeEdges.get(i);
			Vertex source = graph.originVertex.get(s);
			i++;
			s = changeEdges.get(i);
			Vertex dest  =graph.originVertex.get(s);
			int in = source.inPower;
			int index  = source.strEdge.indexOf(source.getName()+dest.getName());
			Edge e = source.edges.get(index);
			int specialPower = e.getWeight();
			System.out.println(source.getName() + " - " + dest.getName() + "    We should increase " + (in-specialPower));
		}
	}
	
}
