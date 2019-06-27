import java.util.*;

public class ShortestPath {
	public static void main(String []args){
		ArrayList<WeightedDirectedEdge> edges = new ArrayList<>();

		edges.add(new WeightedDirectedEdge(0, 1, 5));
		edges.add(new WeightedDirectedEdge(1, 2, 2));
		edges.add(new WeightedDirectedEdge(0, 2, 8));
		edges.add(new WeightedDirectedEdge(2, 4, 3));
		edges.add(new WeightedDirectedEdge(2, 3, 6));
		edges.add(new WeightedDirectedEdge(3, 4, 4));

		WeightedDigraph g = new WeightedDigraph(edges, 5);

		boolean[] visited = new boolean[5];
		int[] leastDis = new int[5];

		for (int i = 1; i < 5; i++) {
			leastDis[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < 5; i++) {
			int minVal = Integer.MAX_VALUE;
			int node = -1;
			for (int j = 0; j < 5; j++) {
				if (!visited[j] &&  leastDis[j] <= minVal) {
					minVal = leastDis[j];
					node = j;
				}
			}

			visited[node] = true;

			for (WeightedDirectedEdge e : g.adj(node)) {
				if (!visited[e.other(node)] && e.weight() + leastDis[node] < leastDis[e.other(node)]) {
					leastDis[e.other(node)] = e.weight() + leastDis[node];
				}
			}
		}

		System.out.println(leastDis[4]);
	}
}