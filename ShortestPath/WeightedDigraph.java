import java.util.*;

public class WeightedDigraph {
	private List<WeightedDirectedEdge> edges;
	private int nodeNum;
	private List<List<WeightedDirectedEdge>> adj;

	WeightedDigraph(List<WeightedDirectedEdge> edges, int nodeNum) {
		this.edges = edges;
		this.nodeNum = nodeNum;

		adj = new ArrayList<List<WeightedDirectedEdge>>();
		for (int i = 0; i < nodeNum; i++) {
			adj.add(new ArrayList<WeightedDirectedEdge>());
		}
		for (WeightedDirectedEdge e : edges) {
			adj.get(e.from).add(e);
		}
	}

	public List<WeightedDirectedEdge> adj(int node) {
		return adj.get(node);
	}

	public int nodeNum() {
		return nodeNum;
	}

	public int edgeNum() {
		return edges.size();
	}
}