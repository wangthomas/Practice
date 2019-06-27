import java.util.*;

public class Digraph {

	private List<Edge> edges;
	private int numNodes;
	private List<List<Edge>> adjList;


	Digraph(List<Edge> edges, int numNodes) {
		this.edges = edges;
		this.numNodes = numNodes;

		adjList = new LinkedList<List<Edge>>();

		for (int i = 0; i < numNodes; i++) {
			LinkedList<Edge> list = new LinkedList<Edge>();
			adjList.add(list);
		}

		for (Edge e : edges) {
			adjList.get(e.from()).add(e);
			adjList.get(e.to()).add(e);
		}
	}

	int NumberOfNodes() {
		return numNodes;
	}

	int NumberOfEdges() {
		return edges.size();
	}

	List<Edge> adj(int node) {
		return adjList.get(node);
	} 

}