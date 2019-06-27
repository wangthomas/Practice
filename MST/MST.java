import java.util.*;

public class MST {
	public static void main(String []args){
		ArrayList<WeightedUndirectEdge> edges = new ArrayList<>();

		edges.add(new WeightedUndirectEdge(0, 1, 5));
		edges.add(new WeightedUndirectEdge(1, 2, 2));
		edges.add(new WeightedUndirectEdge(0, 2, 8));
		edges.add(new WeightedUndirectEdge(2, 4, 3));
		edges.add(new WeightedUndirectEdge(2, 3, 6));
		edges.add(new WeightedUndirectEdge(3, 4, 4));

		WeightedGraph g = new WeightedGraph(edges, 5);

		int min = 0;
		boolean[] visited = new boolean[5];
		int[] leastWeight = new int[5];

		for (int i = 1; i < 5; i++) {
			leastWeight[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < 5; i++) {
			int minVal = Integer.MAX_VALUE;
			int node = -1;
			for (int j = 0; j < 5; j++) {
				if (!visited[j] && leastWeight[j] <= minVal) {
					minVal = leastWeight[j];
					node = j;
				}
			}

			min += minVal;
			visited[node] = true;

			for (WeightedUndirectEdge e : g.adj(node)) {
				if (!visited[e.other(node)] && e.weight() < leastWeight[e.other(node)]) {
					leastWeight[e.other(node)] = e.weight();
				}
			}
		}

		System.out.println(min);

	}

}