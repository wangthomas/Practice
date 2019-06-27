public class WeightedDirectedEdge {
	
	public int from;
	public int to;
	private int weight;

	WeightedDirectedEdge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public int other(int node) {
		if (node == from) {
			return to;
		}
		return from;
	}

	public int weight() {
		return weight;
	}

}