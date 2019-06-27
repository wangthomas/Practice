import java.util.*;

public class WeightedGraph {

	private List<WeightedUndirectEdge> edges;
	private int nodeNum;
	private List<List<WeightedUndirectEdge>> adj;

	WeightedGraph(List<WeightedUndirectEdge> edges, int nodeNum) {
		this.edges = edges;
		this.nodeNum = nodeNum;
		adj = new ArrayList<List<WeightedUndirectEdge>>();
		for (int i = 0; i < nodeNum; i++) {
			adj.add(new ArrayList<WeightedUndirectEdge>());
		}
		for (WeightedUndirectEdge e : edges) {
			adj.get(e.end).add(e);
			adj.get(e.other).add(e);
		}
	}

	public List<WeightedUndirectEdge> adj(int node) {
		return adj.get(node);
	}

	public int nodeNum() {
		return nodeNum;
	}

	public int edgeNum() {
		return edges.size();
	}

}