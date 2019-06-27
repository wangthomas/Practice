import java.util.*;

public class Edge {

	public  int from, to, capacity, current;

	
	Edge(int from, int to, int capacity, int current) {
		this.from = from;
		this.to = to;
		this.capacity = capacity;
		this.current = current;
	}

	public int remain (int start) {
		if (start == from) {
			return capacity - current;
		}
		return current;
vcxz`		}
、
	public void add (int start, int size) {
				if (start == from) {
					current += size;
				} else {
					current -= size;
				}
				return;
			}

			public int other (int start) {
				if (start == from) {
					return to;
				}
				return from;
	}

	public int from () {
		return from;
	}

	public int to () {
		return to;
	}

}