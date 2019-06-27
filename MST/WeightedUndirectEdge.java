public class WeightedUndirectEdge {
	
	public int end;
	public int other;
	public int weight;

	WeightedUndirectEdge(int end, int other, int weight) {
		this.end = end;
		this.other = other;
		this.weight = weight;
	}

	public int other(int node) {
		if (node == end) {
			return other;
		}
		return end;
	}

	public int weight() {
		return weight;
	}
}